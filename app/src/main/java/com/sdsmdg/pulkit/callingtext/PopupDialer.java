package com.sdsmdg.pulkit.callingtext;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class PopupDialer extends AppCompatActivity {

    EditText et_message;
    GifImageView g;
    GifFragment fragment;
    Button call;
    public static String gifNumber1;
    String number, message, yourNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        et_message = (EditText) findViewById(R.id.message);
        call = (Button) findViewById(R.id.btn_call);
        g = (GifImageView) findViewById(R.id.gif_image);
        message = et_message.getText().toString();
        number = getIntent().getExtras().getString("number");
        Log.i("number and message ", message + ":" + number);
        yourNumber = "7253046197";


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("CALLL CLICK ", yourNumber + "" + number + "" + message);
                if (haveNetworkConnection() == true) {
                    final  ComponentName component = new ComponentName(getBaseContext(), CallManager.class);
                    int status = getBaseContext().getPackageManager().getComponentEnabledSetting(component);
                    Log.e("INTSTATUS", status + "nknks");
                    if (status == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
                        Log.e("POPOp", "receiver is enabled");
                    } else if (status == PackageManager.COMPONENT_ENABLED_STATE_DISABLED) {
                        Log.e("POPop", "receiver is disabled");
                    } else {
                        Log.e("POPop", "receiver is nooooone");

                    }
                    //to disable
                    getBaseContext().getPackageManager().setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                    Log.e("POPop", "disable receiver");

                    if (message != null && number != null) {
                        Log.i("REACHED HERe", "YEAAA !!");
                        BackGroundWorker b = new BackGroundWorker(PopupDialer.this, 2);
                        Log.e("number", number);
                        b.execute(yourNumber, number, message, gifNumber1);
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:" + number));
                        Log.e("receiver", "tel:" + number);
                        try {
                            startActivity(callIntent);

                        } catch (SecurityException s) {
                            Log.e("exception", s.toString());

                        }
                    } else {
                        Log.e("in else", "in else");
                        Toast.makeText(PopupDialer.this, "please type your message or number", Toast.LENGTH_SHORT).show();

                    }
                    //to enable
                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    // your code here
                                    getBaseContext().getPackageManager().setComponentEnabledSetting(component, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
                                    Log.e("POPop", "enabled receiver");
                                }
                            },
                            10000
                    );

                    finish();
                    Log.e("FINSIHSSS", "FINNNSHS HIIm");

                } else {
                    Toast.makeText(PopupDialer.this, "you have no internet connection", Toast.LENGTH_SHORT).show();
                    finish();
                    Log.e("FINSIHSSS", "FINNNSIISHS HIIm");

                }


                Log.e("call", "call");
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.setVisibility(View.INVISIBLE);
                GifFragment gifFragment = new GifFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bottom, gifFragment)
                        .addToBackStack(null)
                        .commit();

            }
        });


    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
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
