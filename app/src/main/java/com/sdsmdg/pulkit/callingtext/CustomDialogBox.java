package com.sdsmdg.pulkit.callingtext;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class CustomDialogBox extends AppCompatActivity {
    TextView t;
    GifImageView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        ShapeDrawable rectShapeDrawable = new ShapeDrawable();
        Paint paint = rectShapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#388FF5"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        layout.setBackgroundDrawable(rectShapeDrawable);
       t = (TextView)findViewById(R.id.textView5);
       g=(GifImageView)findViewById(R.id.imageView2);
       int id=Integer.parseInt(CallManager.msg.substring(CallManager.msg.lastIndexOf(" ")+1));
          switch (String.valueOf(id)){
              case "1":
                  g.setImageResource(R.drawable.birthday);
                  break;
              case "2":
                 g.setImageResource(R.drawable.confused);
                  break;
              case "3":
                 g.setImageResource(R.drawable.funny);
                  break;
              case "4":
                  g.setImageResource(R.drawable.embares);
                  break;
              case "5":
                  g.setImageResource(R.drawable.angry);
                  break;
              case "6":
                  g.setImageResource(R.drawable.machau);
                  break;
              case "7":
                 g.setImageResource(R.drawable.sorry);
                  break;
              case "8":
                 g.setImageResource(R.drawable.hii);
                  break;
              case "9":
                 g.setImageResource(R.drawable.hello);
                  break;
              case "10":
                 g.setImageResource(R.drawable.love);
                  break;
              case "11":
                 g.setImageResource(R.drawable.compliment);
                  break;
              case "12":
                  g.setImageResource(R.drawable.happy);
                  break;
              case "13":
                 g.setImageResource(R.drawable.sad);
                  break;
              case "14":
                 g.setImageResource(R.drawable.crying);
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
