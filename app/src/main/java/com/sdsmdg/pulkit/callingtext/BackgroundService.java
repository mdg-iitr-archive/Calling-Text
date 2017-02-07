package com.sdsmdg.pulkit.callingtext;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by pulkit on 4/2/17.
 */

public class BackgroundService extends IntentService {

    DatabaseReference callertree = FirebaseDatabase.getInstance().getReference().child("caller");
    DatabaseReference receivertree = FirebaseDatabase.getInstance().getReference().child("receiver");
    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();
    String name;
    String number;
    String type;
    String time;
    String msg;
    DataBaseHandler dbh;

    public BackgroundService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.child("receiver").child(CallManager.receiver) != null) {
                    Log.e("first","first");
                    Log.e("on data change listener", "on data change listener");
                    BackGroundWorker.value = snapshot.child("receiver").child(CallManager.receiver).child("caller").getValue().toString();
                    BackGroundWorker.gifId = snapshot.child("receiver").child(CallManager.receiver).child("gifId").getValue().toString();
                    BackGroundWorker.msg = snapshot.child("receiver").child(CallManager.receiver).child("message").getValue().toString();
                    Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(BackGroundWorker.value));
                    Cursor phones = getContentResolver().query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
                    while (phones.moveToNext()) {
                        name = phones.getString(phones.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
                    }
                    number = BackGroundWorker.value;
                    type = "incoming";
                    time = DateFormat.getDateTimeInstance().format(new Date());
                    msg=BackGroundWorker.msg;
                    CallerDetails cd =new CallerDetails(name,number,msg,type,time);
                    dbh= DataBaseHandler.getInstance(getBaseContext());
                    dbh.addCaller(cd);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        receivertree.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String s) {

                if (snapshot.child("receiver").child(CallManager.receiver) != null) {
                    BackGroundWorker.value = snapshot.child("receiver").child(CallManager.receiver).child("caller").getValue().toString();
                    BackGroundWorker.gifId = snapshot.child("receiver").child(CallManager.receiver).child("gifId").getValue().toString();
                    BackGroundWorker.msg = snapshot.child("receiver").child(CallManager.receiver).child("message").getValue().toString();
                }

            }

            @Override
            public void onChildChanged(DataSnapshot snapshot, String s) {

                if (snapshot.child("receiver").child(CallManager.receiver) != null) {
                    BackGroundWorker.value = snapshot.child("receiver").child(CallManager.receiver).child("caller").getValue().toString();
                    BackGroundWorker.gifId = snapshot.child("receiver").child(CallManager.receiver).child("gifId").getValue().toString();
                    BackGroundWorker.msg = snapshot.child("receiver").child(CallManager.receiver).child("message").getValue().toString();
                }


            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
        restartServiceIntent.setPackage(getPackageName());

        PendingIntent restartServicePendingIntent = PendingIntent.getService(getApplicationContext(), 1, restartServiceIntent, PendingIntent.FLAG_ONE_SHOT);
//        AlarmManager alarmService = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
//        alarmService.set(
//                AlarmManager.ELAPSED_REALTIME,
//                SystemClock.elapsedRealtime() + 1000,
//                restartServicePendingIntent);

        super.onTaskRemoved(rootIntent);
    }
}
