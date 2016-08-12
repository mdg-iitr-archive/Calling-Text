package com.example.thispc.callingtext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by this pc on 04-08-2016.
 */
public class CallManager extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e("pulkit", "in received");
        String caller="7248187747";
        String receiver="7248187747";
        BackGroundWorker b=new BackGroundWorker(context,1);
        b.execute(caller);
        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage("com.example.thispc.callingtext");
        launchIntent.putExtra("some_data", "value");
        context.startActivity(launchIntent);
    }
}
