package com.sdsmdg.pulkit.callingtext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.telephony.SmsMessage;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

public class CallManager extends BroadcastReceiver implements BackGroundWorker.resultInterface {
    public static Context context1;
    public static String msg;

    @Override
    public void onReceive(Context context, Intent intent) {
        context1 = context;
        Log.e("pul", "in receive");
        Log.e("pulkit", "in received");
        String caller = "7248187747";
        String receiver = "7253046197";
      String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
          if(state!=null) {
          if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            caller = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
              Log.e("caller",caller.substring(0));
            caller = caller.substring(caller.length() - 11);
              Log.e("caller",caller.substring(1));
              caller=caller.substring(1);
              Log.e("receiving number",caller);
            if (haveNetworkConnection() == true) {
                BackGroundWorker b = new BackGroundWorker(context, 1);
                b.execute(caller, receiver);
            }
        }
    }
    }


//        if (intent.getAction() == "android.provider.Telephony.SMS_RECEIVED") {
//            if (haveNetworkConnection() == true) {
//                BackGroundWorker b = new BackGroundWorker(context, 1);
//                b.execute(caller, receiver);
//            }
//        }
//    }

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

    @Override
    public void getContent(String s) {
        Log.e("in content","in content");
        Intent intentone = new Intent(context1.getApplicationContext(), CustomDialogBox.class);
        intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        msg = s;
        context1.startActivity(intentone);
    }
}
