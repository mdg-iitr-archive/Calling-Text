package com.sdsmdg.pulkit.callingtext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class CustomDialogBox extends AppCompatActivity {
    TextView t;
    GifImageView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(com.sdsmdg.pulkit.callingtext.R.layout.dialog);
        t = (TextView)findViewById(com.sdsmdg.pulkit.callingtext.R.id.textView5);
       g=(GifImageView)findViewById(com.sdsmdg.pulkit.callingtext.R.id.imageView2);
       int id=Integer.parseInt(CallManager.msg.substring(CallManager.msg.lastIndexOf(" ")+1));
          switch (String.valueOf(id)){
              case "1":
                  g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.birthday);
                  break;
              case "2":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.confused);
                  break;
              case "3":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.funny);
                  break;
              case "4":
                  g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.embares);
                  break;
              case "5":
                  g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.angry);
                  break;
              case "6":
                  g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.machau);
                  break;
              case "7":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.sorry);
                  break;
              case "8":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.hii);
                  break;
              case "9":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.hello);
                  break;
              case "10":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.love);
                  break;
              case "11":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.compliment);
                  break;
              case "12":
                  g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.happy);
                  break;
              case "13":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.sad);
                  break;
              case "14":
                 g.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.crying);
                  break;
              case "15":

                  break;
              case "16":

                  break;
              case "17":

                  break;
              case "18":

                  break;
              case "19":

                  break;
              case "20":

                  break;
          }
      t.setText((CallManager.msg).substring(0,CallManager.msg.lastIndexOf(" ")));
    }
    public void ok(View v)
    {
        finish();
    }
}
