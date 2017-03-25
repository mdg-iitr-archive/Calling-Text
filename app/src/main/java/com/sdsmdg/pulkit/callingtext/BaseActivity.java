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
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.Toast;

import static com.sdsmdg.pulkit.callingtext.R.layout.activity_base;

public class BaseActivity extends FragmentActivity implements ActionBar.TabListener,GifFragment.onImageselectionListener,HistoryFragment.onCardselectionListener{

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    FragmentManager fragmentManager;
    GifFragment fragment;
    Button btn_settings;
    public static String mname,mnumber;
    public static Boolean calledByapp = false;

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

    public static String receiver="7248187747";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    @Override
    public void onCardSelection(String cPosition) {
        Log.e("inOnCardSelection", "in it");
        CallDetails callDetails=new CallDetails();
        if (callDetails!=null){
           // callDetails.setData(cPosition);
            callDetails.setCallerName(mname);
            callDetails.setCallerNumber(mnumber);
            Fragment newFragment = new CallDetails();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
          //  ft.add(R.layout.content_base, newFragment);
          //  ft.commit();
        }
    }
}
