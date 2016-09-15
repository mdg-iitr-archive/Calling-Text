package com.example.thispc.callingtext;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class CustomDialogBox extends AppCompatActivity {
TextView t;
    GifImageView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        t = (TextView)findViewById(R.id.textView5);
        g=(GifImageView)findViewById(R.id.imageView2);
       int id=Integer.parseInt(CallManager.msg.substring(CallManager.msg.lastIndexOf(" ")+1));
          switch (id){
              case 1:
                  g.setImageResource(R.drawable.birthday);
                  break;
              case 2:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 3:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 4:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 5:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 6:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 7:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 8:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 9:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 10:
                  g.setImageResource(R.drawable.angry);
                  break;
              case 11:
                  g.setImageResource(R.drawable.angry);
                  break;
          }
      t.setText((CallManager.msg).substring(0,CallManager.msg.lastIndexOf(" ")));
    }
    public void Next(View v)
    {
        Intent i=new Intent(CustomDialogBox.this,MainActivity.class);
        startActivity(i);
    }
}
