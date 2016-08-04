package com.example.thispc.callingtext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by this pc on 04-08-2016.
 */
public class CallManager extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.e("pulkit", "in received");
        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage("com.example.thispc.calling_app");
        launchIntent.putExtra("some_data", "value");
        context.startActivity(launchIntent);
        Toast.makeText(context, "received", Toast.LENGTH_SHORT).show();
    }
}
