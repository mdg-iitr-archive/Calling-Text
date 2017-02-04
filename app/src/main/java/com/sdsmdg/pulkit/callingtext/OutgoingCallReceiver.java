//package com.sdsmdg.pulkit.callingtext;
//
///**
// * Created by ajayrahul on 4/2/17.
// */
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.telephony.TelephonyManager;
//import android.util.Log;
//import android.widget.Toast;
//
//public class OutgoingCallReceiver extends BroadcastReceiver {
//    private static final String TAG = OutgoingCallReceiver.class.getSimpleName();
//
//    private static boolean mStateOutgoingCall;
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        String action = intent.getAction();
//
//        if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
//
//            if (mStateOutgoingCall) {
//                return;
//            }
//
//            String number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
//            setResultData(null);
//
//            Log.v(TAG, "tel:" + number);
//            Toast.makeText(context, "tel:" + number, Toast.LENGTH_SHORT).show();
//
//            Intent intentService = new Intent(context, OutgoingCallIntentService.class);
//            intentService.setData(Uri.parse("tel:" + number));
//            context.startService(intentService);
//
//            mStateOutgoingCall = true;
//
//        } else if (action.equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)) {
//
//            String phoneState = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
//            //Toast.makeText(context, phoneState, Toast.LENGTH_LONG).show();
//
//            Log.v(TAG, "onReceive() " + phoneState);
//
//            if (TelephonyManager.EXTRA_STATE_RINGING.equals(phoneState)) {
//            }
//            else if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(phoneState)) {
//            }
//            else if (TelephonyManager.EXTRA_STATE_IDLE.equals(phoneState)) {
//                mStateOutgoingCall = false;
//            }
//        }
//
//    }
//
//}