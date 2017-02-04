package com.sdsmdg.pulkit.callingtext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by pulkit on 2/2/17.
 */

public class PopupDialerReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("PopupDialer","in onReceive");
        Intent intentone = new Intent(context.getApplicationContext(), PopupDialer.class);
        intentone.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentone);
    }
}
