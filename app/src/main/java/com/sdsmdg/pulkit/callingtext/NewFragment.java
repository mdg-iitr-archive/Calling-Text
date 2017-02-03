package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class NewFragment extends Fragment implements View.OnClickListener {
    private final int REQUEST_CODE = 1;
    EditText editText1;
    EditText editText2;
    public EditText editName;
    String yourNumber, yourName;
    GifImageView img;
    TextView t1;
    GifFragment fragment;
    View view;
    Button call;
    Button save;
    public static String gifNumber1;
    private static final int CONTACTS_LOADER_ID = 1;
    private WindowManager windowManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);
        View view = inflater.inflate(R.layout.new_fragment, container, false);
        editText1 = (EditText) view.findViewById(R.id.editText2);
        editText2 = (EditText) view.findViewById(R.id.editText);
        editName = (EditText) view.findViewById(R.id.editText3);
        yourNumber = "7253046197";
        t1 = (TextView) view.findViewById(R.id.textView5);
        img = (GifImageView) view.findViewById(R.id.imageView3);

        editName.setText(BaseActivity.getMname());
        img.setOnClickListener(this);
        call = (Button) view.findViewById(R.id.button4);
        call.setOnClickListener(this);
        save = (Button) view.findViewById(R.id.button3);
        save.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {


            case R.id.button4:
                if (haveNetworkConnection() == true) {
                    if (editText2.getText().toString() != null && editText1.getText().toString() != null) {
                        BackGroundWorker b = new BackGroundWorker(getActivity(), 2);
                        Log.e("number", editText1.getText().toString());
                        b.execute(yourNumber, editText1.getText().toString(), editText2.getText().toString(), gifNumber1);
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:7253046197"));
                        startActivity(callIntent);
                    } else {
                        Log.e("in else", "in else");
                        Toast.makeText(getActivity(), "please type your message or number", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(getActivity(), "you have no internet connection", Toast.LENGTH_SHORT).show();
                Log.e("call", "call");
                break;
            case R.id.button3:
                if (haveNetworkConnection() == true) {
                    if (editText2.getText().toString() != null) {
                        BackGroundWorker b = new BackGroundWorker(getActivity(), 2);
                        b.execute(yourNumber, editText1.getText().toString(), editText2.getText().toString(), gifNumber1);
                    } else {
                        Log.e("in else", "in else");
                        Toast.makeText(getActivity(), "please type message", Toast.LENGTH_SHORT).show();
                    }
                } else
                    Toast.makeText(getActivity(), "you have no internet connection", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView3:
                save.setVisibility(View.INVISIBLE);
                call.setVisibility(View.INVISIBLE);
                GifFragment gifFragment = new GifFragment();
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.bottom, gifFragment, null)
                        .addToBackStack(null)
                        .commit();
                break;
            default:
                break;

        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

   /* public void OK(View v) {
        Uri uri = Uri.parse("content://contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        startActivityForResult(intent, REQUEST_CODE);
    }

    /* private void call(String s) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
         callIntent.setData(Uri.parse("tel:" + s));
         try{
         startActivity(callIntent);}
         catch (android.content.ActivityNotFoundException ex){
             Toast.makeText(getActivity(),"yourActivity is not found",Toast.LENGTH_SHORT).show();}
     }*/


    public void setImage(String gifNumber) {
        Log.e("pul", "pul");
        gifNumber1 = gifNumber;
        save.setVisibility(View.VISIBLE);
        call.setVisibility(View.VISIBLE);
        switch (gifNumber) {
            case "1":
                Log.e("in 1", "in 1");
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
            default:
                img.setImageResource(R.drawable.birthday);
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

        return true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("NewFragment", "Detached");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("NewFragment", "Attached");
//        editName.setText(BaseActivity.getMname());


    }
}