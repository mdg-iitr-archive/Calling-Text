package com.example.thispc.callingtext;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
private final int REQUEST_CODE=1;
    EditText editText1;
    EditText editText2;
    String yourNumber;
    String receiver;
    GifImageView img;
    public static String gifNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        editText1=(EditText)findViewById(R.id.editText2);
        editText2=(EditText)findViewById(R.id.editText);
        setSupportActionBar(toolbar);
        yourNumber="7248187747";
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        img =(GifImageView)findViewById(R.id.imageView3);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
public void OK(View v)
{
    Uri uri = Uri.parse("content://contacts");
    Intent intent = new Intent(Intent.ACTION_PICK, uri);
    intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
    startActivityForResult(intent, REQUEST_CODE);
}
    public void custom(View v)
    {
        Intent ic =new Intent(MainActivity.this,CustomDialogBox.class);
        startActivity(ic);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void call(View v)
    {
        if(editText1.getText().toString()!=null)
        {
            receiver=editText1.getText().toString();
            call(editText1.getText().toString());
        }else
            Toast.makeText(getApplicationContext(),"Please Enter Number",Toast.LENGTH_SHORT).show();
    }
    private void call(String s) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+s));
        try{
        startActivity(callIntent);}
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not found",Toast.LENGTH_SHORT).show();}

    }
    public void send(View v)
    {
        if(haveNetworkConnection()==true){
            if(editText2.getText().toString()!=null)
            {
                BackGroundWorker b=new BackGroundWorker(this,2);
                b.execute(yourNumber,editText1.getText().toString(),editText2.getText().toString(),gifNumber);
            }else
                Toast.makeText(getApplicationContext(),"please type message",Toast.LENGTH_SHORT).show();
           }else
            Toast.makeText(getApplicationContext(),"you have no internet connection",Toast.LENGTH_SHORT).show();
    }
    public void gif(View v)
    {
        Intent i=new Intent(MainActivity.this,GifActivity.class);
        startActivityForResult(i, 0);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            Log.e("pul", "pul");
            switch (MainActivity.gifNumber) {
                case "1":
                    img.setImageResource(R.drawable.birthday);
                    break;
                case "2":
                    img.setImageResource(R.drawable.confused);
                    break;
                case "3":
                    img.setImageResource(R.drawable.funny);
                    break;
                case "4":
                    img.setImageResource(R.drawable.embares);
                    break;
                case "5":
                    img.setImageResource(R.drawable.angry);
                    break;
                case "6":
                    img.setImageResource(R.drawable.machau);
                    break;
                case "7":
                    img.setImageResource(R.drawable.sorry);
                    break;
                case "8":
                    img.setImageResource(R.drawable.hii);
                    break;
                case "9":
                    img.setImageResource(R.drawable.hello);
                    break;
                case "10":
                    img.setImageResource(R.drawable.love);
                    break;
                case "11":
                    img.setImageResource(R.drawable.compliment);
                    break;
                case "12":
                    img.setImageResource(R.drawable.happy);
                    break;
                case "13":
                    img.setImageResource(R.drawable.sad);
                    break;
                case "14":
                    img.setImageResource(R.drawable.crying);
                    break;
                case "15":

                    break;
                case "16":

                    break;
                case "17":

                    break;
                case "18":

                    break;
                case "19":

                    break;
                case "20":

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
