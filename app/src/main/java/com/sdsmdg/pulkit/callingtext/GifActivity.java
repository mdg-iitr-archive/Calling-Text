package com.sdsmdg.pulkit.callingtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class GifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sdsmdg.pulkit.callingtext.R.layout.activity_gif);
        Toolbar toolbar = (Toolbar) findViewById(com.sdsmdg.pulkit.callingtext.R.id.toolbar);
      //setSupportActionBar(toolbar);
    }
    public void row(View v)
    {
        switch (v.getId()) {
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton:
                MainActivity.gifNumber="1";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton2:
                MainActivity.gifNumber="2";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton3:
                MainActivity.gifNumber="3";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton4:
                MainActivity.gifNumber="4";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton5:
                MainActivity.gifNumber="5";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton6:
                MainActivity.gifNumber="6";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton7:
                MainActivity.gifNumber="7";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton8:
                MainActivity.gifNumber="8";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton9:
                MainActivity.gifNumber="9";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton10:
                MainActivity.gifNumber="10";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton11:
                MainActivity.gifNumber="11";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton12:
                MainActivity.gifNumber="12";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton13:
                MainActivity.gifNumber="13";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton14:
                MainActivity.gifNumber="14";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton15:
                MainActivity.gifNumber="15";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton16:
                MainActivity.gifNumber="16";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton17:
                MainActivity.gifNumber="17";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton18:
                MainActivity.gifNumber="18";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton19:
                MainActivity.gifNumber="19";
                
                break;
            case com.sdsmdg.pulkit.callingtext.R.id.imageButton20:
                MainActivity.gifNumber="20";
                
                break;
        }
        finish();
    }


}
