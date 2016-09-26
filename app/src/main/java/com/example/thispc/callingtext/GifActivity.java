package com.example.thispc.callingtext;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class GifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      //setSupportActionBar(toolbar);
    }
    public void row(View v)
    {
        switch (v.getId()) {
            case R.id.imageButton:
                MainActivity.gifNumber="1";
                
                break;
            case R.id.imageButton2:
                MainActivity.gifNumber="2";
                
                break;
            case R.id.imageButton3:
                MainActivity.gifNumber="3";
                
                break;
            case R.id.imageButton4:
                MainActivity.gifNumber="4";
                
                break;
            case R.id.imageButton5:
                MainActivity.gifNumber="5";
                
                break;
            case R.id.imageButton6:
                MainActivity.gifNumber="6";
                
                break;
            case R.id.imageButton7:
                MainActivity.gifNumber="7";
                
                break;
            case R.id.imageButton8:
                MainActivity.gifNumber="8";
                
                break;
            case R.id.imageButton9:
                MainActivity.gifNumber="9";
                
                break;
            case R.id.imageButton10:
                MainActivity.gifNumber="10";
                
                break;
            case R.id.imageButton11:
                MainActivity.gifNumber="11";
                
                break;
            case R.id.imageButton12:
                MainActivity.gifNumber="12";
                
                break;
            case R.id.imageButton13:
                MainActivity.gifNumber="13";
                
                break;
            case R.id.imageButton14:
                MainActivity.gifNumber="14";
                
                break;
            case R.id.imageButton15:
                MainActivity.gifNumber="15";
                
                break;
            case R.id.imageButton16:
                MainActivity.gifNumber="16";
                
                break;
            case R.id.imageButton17:
                MainActivity.gifNumber="17";
                
                break;
            case R.id.imageButton18:
                MainActivity.gifNumber="18";
                
                break;
            case R.id.imageButton19:
                MainActivity.gifNumber="19";
                
                break;
            case R.id.imageButton20:
                MainActivity.gifNumber="20";
                
                break;
        }
        finish();
    }


}
