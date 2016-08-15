package com.example.thispc.callingtext;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CustomDialogBox extends AppCompatActivity {
TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_box);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t=(TextView)findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("msg")!= null)
        {
            t.setText(bundle.getString("msg"));
        }
    }
    public void Next(View v)
    {
        Intent i=new Intent(CustomDialogBox.this,MainActivity.class);
        startActivity(i);
    }
}
