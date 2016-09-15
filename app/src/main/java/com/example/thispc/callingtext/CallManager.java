package com.example.thispc.callingtext;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by this pc on 04-08-2016.
 */
public class CallManager extends BroadcastReceiver implements Observer{
    public static Context context1;
    public static String msg;
    @Override
    public void onReceive(Context context, Intent intent) {
        context1=context;
        Log.e("pul","in receive");
        Log.e("pulkit", "in received");
        String caller="724818774";
        String receiver="724818774";
     if(haveNetworkConnection()==true){
      BackGroundWorker b=new BackGroundWorker(context,1);
      b.execute(caller,receiver);
        }
    }
   @Override
    public void update(Observable observable, Object data) {
       if(((result)observable).getContent()!=null)
        {
          /*Intent i = new Intent(context1,CustomDialogBox.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);*/
         Intent intentone = new Intent(context1.getApplicationContext(), CustomDialogBox.class);
            intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            CallManager.msg=((result)observable).getContent();
            context1.startActivity(intentone);
        }
    }
  private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context1.getSystemService(context1.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
}
