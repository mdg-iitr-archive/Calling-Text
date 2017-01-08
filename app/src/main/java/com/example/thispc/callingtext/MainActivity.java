package com.example.thispc.callingtext;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.support.v4.content.Loader;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;
public class MainActivity extends Fragment
{
    private final int REQUEST_CODE = 1;
    EditText editText1;
    EditText editText2;
    String yourNumber;
    String receiver;
    GifImageView img;
    FragmentManager fragmentManager;
    TextView t1;
    GIF fragment;
    View view;
    public static String gifNumber;
    private static final int CONTACTS_LOADER_ID = 1;
    private WindowManager windowManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        View view = inflater.inflate(R.layout.activity_main, container, false);
        editText1 = (EditText) view.findViewById(R.id.editText2);
        editText2 = (EditText) view.findViewById(R.id.editText);
        yourNumber = "7248187747";
        t1 = (TextView) view.findViewById(R.id.textView5);
        img = (GifImageView) view.findViewById(R.id.imageView3);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       editText1.setText((getIntent().getExtras().getString("number")));
       /* view.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view,MotionEvent event) {


                Log.e("pul","pul");
                if ( event.getAction () == MotionEvent.ACTION_UP )
                {
                    //and only is the ListFragment shown.
                    if (fragment.isVisible())
                    {
                        // create a rect for storing the fragment window rect
                        Rect r = new Rect ( 0, 0, 0, 0 );

                        fragment.getView().getHitRect(r);
                        // check if the event position is inside the window rect
                        boolean intersects = r.contains ( (int) event.getX (), (int) event.getY () );
                        // if the event is not inside then we can close the fragment

                            FragmentTransaction fragmentTransaction;
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.remove(fragment).commit();
                            Log.e("pulkit","pul");
                            // notify that we consumed this event
                            return true;
                    }
                }
                //let the system handle the event
              return onTouchEvent ( event );
            }
        });*/
    }

   /* public void OK(View v) {
        Uri uri = Uri.parse("content://contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void custom(View v) {
        Intent ic = new Intent(getActivity(), CustomDialogBox.class);
        startActivity(ic);
    }*/

   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    public void call(View v) {
        Toast.makeText(getActivity(),"message",Toast.LENGTH_LONG).show();
        /*if (editText1.getText().toString() != null) {
            //receiver=editText1.getText().toString();
            call(editText1.getText().toString());
        } else
            Toast.makeText(getActivity(), "Please Enter Number", Toast.LENGTH_SHORT).show();*/
    }

   /* private void call(String s) {
       Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + s));
        try{
        startActivity(callIntent);}
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getActivity(),"yourActivity is not found",Toast.LENGTH_SHORT).show();}
    }

    public void send(View v) {
        if (haveNetworkConnection() == true) {
            if (editText2.getText().toString() != null) {
                BackGroundWorker b = new BackGroundWorker(getActivity(), 2);
                b.execute(yourNumber, "7248187747", editText2.getText().toString(), gifNumber);
            } else
                Toast.makeText(getActivity(), "please type message", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(getActivity(), "you have no internet connection", Toast.LENGTH_SHORT).show();

    }*/

    public void gif(View v) {
//        Intent i = new Intent(MainActivity.this, GifActivity.class);
//        startActivityForResult(i, 0);
        //fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         fragment = new GIF();
        fragmentTransaction.add(R.id.bottom, fragment);
        fragmentTransaction.commit();

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
                   img.setImageResource(R.drawable.worried);
                    break;
                case "16":
                    img.setImageResource(R.drawable.praying);
                    break;
                case "17":
                   img.setImageResource(R.drawable.smoking);
                    break;
                case "18":
                   img.setImageResource(R.drawable.birthday);
                    break;
                case "19":
                    img.setImageResource(R.drawable.birthday);
                    break;
                case "20":
                   img.setImageResource(R.drawable.envy);
                    break;

            }
        }
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
   //@Override
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

        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}