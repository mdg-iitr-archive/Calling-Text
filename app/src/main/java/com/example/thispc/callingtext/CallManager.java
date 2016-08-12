package com.example.thispc.callingtext;

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
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by this pc on 04-08-2016.
 */
public class CallManager extends BroadcastReceiver implements Observer{
    Context context1;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        context1=context;
        Log.e("pulkit", "in received");
        String caller="7248187747";
        String receiver="7248187747";
        if(haveNetworkConnection()==true){
        BackGroundWorker b=new BackGroundWorker(context,1);
        b.execute(caller);}
    }
    @Override
    public void update(Observable observable, Object data) {
       if(((result)observable).getContent()!=null)
        {
            PackageManager pm = context1.getPackageManager();
            Intent launchIntent = pm.getLaunchIntentForPackage("com.example.thispc.callingtext");
            launchIntent.putExtra("msg", ((result)observable).getContent());
            context1.startActivity(launchIntent);
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
