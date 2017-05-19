package com.sdsmdg.pulkit.callingtext;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.HashMap;

import static com.sdsmdg.pulkit.callingtext.R.layout.activity_base;

public class BaseActivity extends FragmentActivity implements ActionBar.TabListener,GifFragment.onImageSelectionListener
{


    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    FragmentManager fragmentManager;
    GifFragment fragment;
    Button btn_settings;
    public static String mname,mnumber, mmessage;
    public static Boolean calledByapp = false;
    public static HashMap<String,Integer> imageIds;

    public static String getMname() {
        return mname;
    }

    public static void setMname(String mname) {
        BaseActivity.mname = mname;
    }

    public static String getMnumber() {
        return mnumber;
    }

    public static void setMnumber(String mnumber) {
        BaseActivity.mnumber = mnumber;
    }

    public static  String getMmessage(){return mmessage;}

    public static void setMmessage(String mmessage){BaseActivity.mmessage=mmessage;}

    public static String receiver="7248187747";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(activity_base);
        btn_settings = (Button)findViewById(R.id.btn_settings);
        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this,Settings.class);
                startActivity(intent);
            }
        });

        //Toolbar toolbar= (Toolbar) findViewById(R.id.my_toolbar);
        //((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        if(getIntent().getExtras()!=null && getIntent().getExtras().getString("gotocalldetails")=="1"){
           CallDetailsFragment callDetailsFragment =new CallDetailsFragment();
            Bundle args= new Bundle();
            args.putString("call_number",getMnumber());
            args.putString("call_text", getMmessage());
            callDetailsFragment.setArguments(args);

            android.support.v4.app.FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.mycontainer,callDetailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        TelephonyManager tMgr = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();
        Log.e("MY BA NO.","PHONE NO."+mPhoneNumber);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        int pg_number = 0;
        viewPager.setAdapter(mAdapter);
//        if(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("NUMBER", "7248187747")!=null){
//            receiver = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("NUMBER", "7248187747");
//        }

        if(getIntent().getExtras()!= null){
            try {
                pg_number = Integer.parseInt(getIntent().getExtras().getString("pagenumber"));

            }catch (NumberFormatException num){
                Log.i("EXCEpTION",num.toString());
            }
        }
        viewPager.setCurrentItem(pg_number);

        imageIds=new HashMap<>();
        imageIds.put("1",R.drawable.birthday);
        imageIds.put("2",R.drawable.confused);
        imageIds.put("3",R.drawable.funny);
        imageIds.put("4",R.drawable.embares);
        imageIds.put("5",R.drawable.angry);
        imageIds.put("6",R.drawable.machau);
        imageIds.put("7",R.drawable.sorry);
        imageIds.put("8",R.drawable.hii);
        imageIds.put("9",R.drawable.hello);
        imageIds.put("10",R.drawable.love);
        imageIds.put("11",R.drawable.compliment);
        imageIds.put("12",R.drawable.happy);
        imageIds.put("13",R.drawable.sad);
        imageIds.put("14",R.drawable.crying);

       /* actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);*/

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        startService(new Intent(this, BackgroundService.class));
    }

        private void call(String s) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + s));
        try{
            startActivity(callIntent);}
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(BaseActivity.this,"yourActivity is not found",Toast.LENGTH_SHORT).show();}

        }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onImageSelection(String position) {
        Log.e("in Imageselection","in !!!!");
        Log.e("in null",getSupportFragmentManager().getFragments().get(0).getTag());
        NewFragment newFragment = (NewFragment)
                getSupportFragmentManager().getFragments().get(2
                );

        if (newFragment != null) {
          Log.e("in null","in null");
            newFragment.setImage(position);
        }
    }


}
