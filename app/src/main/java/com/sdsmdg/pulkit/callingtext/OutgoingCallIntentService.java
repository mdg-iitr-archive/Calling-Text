//package com.sdsmdg.pulkit.callingtext;
//
///**
// * Created by ajayrahul on 4/2/17.
// */
//import android.app.IntentService;
//import android.content.Intent;
//import android.util.Log;
//
//public class OutgoingCallIntentService extends IntentService {
//    static final public String TAG = OutgoingCallIntentService.class.getSimpleName();
//
//    public OutgoingCallIntentService(String name) {
//        super(name);
//    }
//
//    public OutgoingCallIntentService() {
//        super(TAG);
//    }
//
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        Log.v(TAG, "onHandleIntent()");
//
//        Intent intentActivity = new Intent(Intent.ACTION_CALL);
//        intentActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intentActivity.setData(intent.getData());
//        startActivity(intentActivity);
//
//    }
//}
