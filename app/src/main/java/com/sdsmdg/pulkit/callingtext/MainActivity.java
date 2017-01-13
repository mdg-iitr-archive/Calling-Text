package com.sdsmdg.pulkit.callingtext;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1;
    EditText editText1;
    EditText editText2;
    String yourNumber;
    String receiver;
    GifImageView img;
    TextView t1;
    public static String gifNumber;
    private static final int CONTACTS_LOADER_ID = 1;
    private WindowManager windowManager;
    String value="";
//    DatabaseReference callertree = FirebaseDatabase.getInstance().getReference().child("caller");
    DatabaseReference dr = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.sdsmdg.pulkit.callingtext.R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        editText1 = (EditText) findViewById(com.sdsmdg.pulkit.callingtext.R.id.editText2);
        editText2 = (EditText) findViewById(com.sdsmdg.pulkit.callingtext.R.id.editText);
        //   t1 = (TextView) findViewById(R.id.textView5);
        yourNumber = "7248147";
        img = (GifImageView) findViewById(com.sdsmdg.pulkit.callingtext.R.id.imageView3);
        // NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
//       editText1.setText((getIntent().getExtras().getString("number")));
    }


    public void OK(View v) {
//        Uri uri = Uri.parse("content://contacts");
//        Intent intent = new Intent(Intent.ACTION_PICK, uri);
//        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
//        startActivityForResult(intent, REQUEST_CODE);

    }
public void fuck(View v)
{
    dr.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot snapshot) {

            value=snapshot.child("caller").child("7248187747").child("receiver").getValue().toString();
        }

        @Override
        public void onCancelled(DatabaseError firebaseError) {
        }
    });
    Log.e("json",value);
}
    public void custom(View v) {
        Intent ic = new Intent(MainActivity.this, CustomDialogBox.class);
        startActivity(ic);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.sdsmdg.pulkit.callingtext.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void call(View v) {
        if (editText1.getText().toString() != null) {
            //receiver=editText1.getText().toString();
            call(editText1.getText().toString());
        } else
            Toast.makeText(getApplicationContext(), "Please Enter Number", Toast.LENGTH_SHORT).show();
    }

    private void call(String s) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + s));
        try {
            startActivity(callIntent);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "yourActivity is not found", Toast.LENGTH_SHORT).show();
        }
    }

    public void send(View v) {
        if (haveNetworkConnection() == true) {
            if (editText2.getText().toString() != null) {
                BackGroundWorker b = new BackGroundWorker(this, 2);
                b.execute(yourNumber, "72481877", editText2.getText().toString(), gifNumber);
            } else
                Toast.makeText(getApplicationContext(), "please type message", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getApplicationContext(), "you have no internet connection", Toast.LENGTH_SHORT).show();

    }

    public void gif(View v) {
        Intent i = new Intent(MainActivity.this, GifActivity.class);
        startActivityForResult(i, 0);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            Log.e("pul", "pul");
            switch (MainActivity.gifNumber) {
                case "1":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.birthday);
                    break;
                case "2":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.confused);
                    break;
                case "3":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.funny);
                    break;
                case "4":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.embares);
                    break;
                case "5":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.angry);
                    break;
                case "6":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.machau);
                    break;
                case "7":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.sorry);
                    break;
                case "8":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.hii);
                    break;
                case "9":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.hello);
                    break;
                case "10":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.love);
                    break;
                case "11":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.compliment);
                    break;
                case "12":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.happy);
                    break;
                case "13":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.sad);
                    break;
                case "14":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.crying);
                    break;
                case "15":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.worried);
                    break;
                case "16":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.praying);
                    break;
                case "17":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.smoking);
                    break;
                case "18":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.birthday);
                    break;
                case "19":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.birthday);
                    break;
                case "20":
                    img.setImageResource(com.sdsmdg.pulkit.callingtext.R.drawable.envy);
                    break;

            }
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.sdsmdg.pulkit.callingtext.R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == com.sdsmdg.pulkit.callingtext.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    //@Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == com.sdsmdg.pulkit.callingtext.R.id.nav_camera) {
            // Handle the camera action
        } else if (id == com.sdsmdg.pulkit.callingtext.R.id.nav_gallery) {

        } else if (id == com.sdsmdg.pulkit.callingtext.R.id.nav_slideshow) {

        } else if (id == com.sdsmdg.pulkit.callingtext.R.id.nav_manage) {

        } else if (id == com.sdsmdg.pulkit.callingtext.R.id.nav_share) {

        } else if (id == com.sdsmdg.pulkit.callingtext.R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.sdsmdg.pulkit.callingtext.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}