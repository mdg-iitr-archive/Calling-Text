package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Observable;

/**
 * Created by this pc on 08-08-2016.
 */
public class BackGroundWorker extends AsyncTask<String, Void, String> {
    private Context context;
    String caller, receiver;
    int n1;
    CallManager cm;
    result r;
    String value = "";
    String gifId;
    String msg;
    DatabaseReference callertree = FirebaseDatabase.getInstance().getReference().child("caller");
    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();

    public BackGroundWorker(Context context1, int n) {
        context = context1;
        n1 = n;
        caller = "7248187747";
        receiver = "7248187747";
        r=new result();
    }

    @Override
    protected String doInBackground(String... params) {
        if (n1 == 1) {
            caller = params[0];
            receiver = params[1];
            dr.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {

                    value = snapshot.child("caller").child(caller).child("receiver").getValue().toString();
                    gifId=snapshot.child("caller").child(caller).child("gifId").getValue().toString();
                    msg=snapshot.child("caller").child(caller).child("msg").getValue().toString();
                }

                @Override
                public void onCancelled(DatabaseError firebaseError) {
                }
            });
            Log.e("json", value);
            if (value == receiver)
            {
               r.call(msg+" "+gifId);
            }
        } else {
            caller = params[0];
            receiver = params[1];
            msg = params[2];
            gifId = params[3];
            callertree.child(caller.toString()).child("receiver").setValue(receiver);
            callertree.child(caller.toString()).child("message").setValue(msg);
            callertree.child(caller.toString()).child("gifId").setValue(gifId);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if (n1 == 1)
            r.call(result);
        else
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}

class result extends Observable {
    String s1;

    public void call(String s) {
        this.s1 = s;
        setChanged();
        notifyObservers(s);
    }

    public synchronized String getContent() {
        return s1;
    }
}
