package com.sdsmdg.pulkit.callingtext;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    public static RecyclerView recList;
    Button button;
    public static ImageButton button1;
    EditText et1;
    List<ArrayList> result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sdsmdg.pulkit.callingtext.R.layout.activity_contact_list);
        button1=(ImageButton)findViewById(com.sdsmdg.pulkit.callingtext.R.id.imageButton21);
      button=(Button)findViewById(com.sdsmdg.pulkit.callingtext.R.id.button5);
        et1=(EditText) findViewById(com.sdsmdg.pulkit.callingtext.R.id.editText3);
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if(et1.getText().toString().equals(""))
                {
                     addToList();
                }
                else
               {
                   searchTtem(et1.getText().toString());
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // getSupportLoaderManager().initLoader(1, null, this);
        recList = (RecyclerView) findViewById(com.sdsmdg.pulkit.callingtext.R.id.questionList_recycler);
        addToList();
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri CONTENT_URI = ContactsContract.RawContacts.CONTENT_URI;
        Log.e("pul","in loader");
        return new CursorLoader(this, CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        Log.e("pul","in loadFinished");
        Log.e("pul",cursor.getCount()+" ");
        cursor.moveToFirst();
        StringBuilder res = new StringBuilder();
        while (!cursor.isAfterLast()) {
            Log.e("pul","in while");
            res.append("\n" + cursor.getString(21) + "-" + cursor.getString(22));
            cursor.moveToNext();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
    private List<ArrayList> createList() {
       result=new ArrayList<ArrayList>();
        ArrayList<String> a=new ArrayList<String>();
        a.add("pulkit");
        a.add("7248187747");
        result.add(a);
        a=new ArrayList<String>();
        a.add("karira");
        a.add("7248187747");
        result.add(a);
        a=new ArrayList<String>();
        a.add("palash");
        a.add("7248187747");
        result.add(a);
        a=new ArrayList<String>();
        a.add("rohit");
        a.add("7248187747");
        result.add(a);
        a=new ArrayList<String>();
        a.add("aman");
        a.add("7248187747");
        result.add(a);
        a=new ArrayList<String>();
        a.add("tim");
        a.add("7248187747");
        result.add(a);
        a.add("namit");
        a.add("7248187747");
        result.add(a);
        a.add("pulkit");
        a.add("7248187747");
        result.add(a);
        a.add("pulkit");
        a.add("7248187747");
        result.add(a);
        a.add("pulkit");
        a.add("7248187747");
        result.add(a);
        a.add("pulkit");
        a.add("7248187747");
        result.add(a);
        return result;
    }
    public void addToList(){
        Log.e("pulkit","pulkit");
      recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ContactListAdapter ca = new ContactListAdapter(createList(),this);
        recList.setAdapter(ca);
    }
    public void newcontact(View v)
    {
        button.startAnimation(
                AnimationUtils.loadAnimation(ContactList.this, com.sdsmdg.pulkit.callingtext.R.anim.rotation) );
        Intent intent = new Intent(ContactList.this, MainActivity.class);
      intent.putExtra("number","");
        startActivity(intent);

    }
    public  void searchTtem(String s)
    {
        for(int i=0;i<result.size();i++)
        {
            if(!((result.get(i)).get(0)).toString().contains(s))
            {
                result.remove(i);
            }
        }
        ContactListAdapter ca = new ContactListAdapter(result,this);
        recList.setAdapter(ca);
    }
}
