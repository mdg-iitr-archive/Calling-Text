package com.example.thispc.callingtext;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.content.Intent;
import android.support.v4.content.Loader;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;
public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>
{
    public static RecyclerView recList;
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
    private ImageView chatHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editText1 = (EditText) findViewById(R.id.editText2);
        editText2 = (EditText) findViewById(R.id.editText);
     //   t1 = (TextView) findViewById(R.id.textView5);
        yourNumber = "7248187747";
       img = (GifImageView) findViewById(R.id.imageView3);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
       // getSupportLoaderManager().initLoader(1, null, this);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        recList = (RecyclerView) findViewById(R.id.questionList_recycler);
        addToList();
         //navigationView.setNavigationItemSelectedListener(this);
      /*  windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

        chatHead = new ImageView(this);
        chatHead.setImageResource(R.drawable.birthday);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.x = 0;
        params.y = 100;

        windowManager.addView(chatHead, params);*/
    }

    public void OK(View v) {
        Uri uri = Uri.parse("content://contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void custom(View v) {
        Intent ic = new Intent(MainActivity.this, CustomDialogBox.class);
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
        try{
        startActivity(callIntent);}
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"yourActivity is not found",Toast.LENGTH_SHORT).show();}
       // readContacts();

    }

    public void send(View v) {
        if (haveNetworkConnection() == true) {
            if (editText2.getText().toString() != null) {
                BackGroundWorker b = new BackGroundWorker(this, 2);
                b.execute(yourNumber, "7248187747", editText2.getText().toString(), gifNumber);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri CONTENT_URI = ContactsContract.RawContacts.CONTENT_URI;
        Log.e("pul","in loader");
        return new CursorLoader(this, CONTENT_URI, null, null, null, null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        Log.e("pul","in loadFinished");
        Log.e("pul",cursor.getCount()+" ");
        cursor.moveToFirst();
        StringBuilder res = new StringBuilder();
        while (!cursor.isAfterLast()) {
            Log.e("pul","in while");
            res.append("\n" + cursor.getString(21) + "-" + cursor.getString(22));

            cursor.moveToNext();
        }
       // t1.setText(res);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
    private List<String> createList() {
        List<String> result=new ArrayList<String>();
        result.add("pulkit");
        result.add("piyush");
        result.add("palash");
        result.add("pramit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        result.add("pulkit");
        return result;
    }
    public void addToList(){
        Log.e("pulkit","pulkit");
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        ContactListAdapter ca = new ContactListAdapter(createList(),this);
        recList.setAdapter(ca);
    }
}