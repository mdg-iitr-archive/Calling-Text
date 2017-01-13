package com.sdsmdg.pulkit.callingtext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class CallManager extends BroadcastReceiver implements Observer{
    public static Context context1;
    public static String msg;
    @Override
    public void onReceive(Context context, Intent intent) {
        context1=context;
        Log.e("pul","in receive");
        Log.e("pulkit", "in received");
        String caller="77";
        String receiver="7247";
      String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
          if(state!=null) {
          if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            //caller = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
           // caller = caller.substring(caller.length() - 11);
            if (haveNetworkConnection() == true) {
                BackGroundWorker b = new BackGroundWorker(context, 1);
                b.execute(caller, receiver);
            }
        }
    }
        else
        if(haveNetworkConnection()==true){
        BackGroundWorker b=new BackGroundWorker(context,1);
        b.execute(caller,receiver);
        }
    }
   @Override
    public void update(Observable observable, Object data) {
       if(((result)observable).getContent()!=null)
        {
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
