package com.example.thispc.callingtext;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

public class Main3Activity extends FragmentActivity implements ActionBar.TabListener {

    TabHost tabHost;
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    FragmentManager fragmentManager;
    GIF fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
       /* actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);*/
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setTabTextColors();
             tabLayout.setupWithViewPager(viewPager);
        }
    public void call(View v) {
        Toast.makeText(Main3Activity.this,"message",Toast.LENGTH_LONG).show();
        /*if (editText1.getText().toString() != null) {
            //receiver=editText1.getText().toString();
            call(editText1.getText().toString());
        } else
            Toast.makeText(getActivity(), "Please Enter Number", Toast.LENGTH_SHORT).show();*/
    }
    private void call(String s) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + s));
        try{
            startActivity(callIntent);}
        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(Main3Activity.this,"yourActivity is not found",Toast.LENGTH_SHORT).show();}
    }
    public void gif(View v) {
        Log.e("p","in gif");
        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new GIF();
        fragmentTransaction.add(fragment,null);
        fragmentTransaction.commit();

    }
    /*@Override
    public void onTabChanged(String tabId) {
        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
        {
            if(i==0) {
                tabHost.getTabWidget().getChildAt(i).setBackgroundColor(0x0000FF00);
                TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
                tv.setTextSize(17);
                tv.setTextColor(Color.parseColor("#ffffff"));
            }
            else if(i==1)
            {
                tabHost.getTabWidget().getChildAt(i).setBackgroundColor(0x0000FF00);
                TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                tv.setTextSize(17);
                tv.setTextColor(Color.parseColor("#ffffff"));}
            else if(i==2)
            {
                tabHost.getTabWidget().getChildAt(i).setBackgroundColor(0x0000FF00);
                TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                tv.setTextSize(17);
                tv.setTextColor(Color.parseColor("#ffffff"));}
        }


        Log.i("tabs", "CurrentTab: "+tabHost.getCurrentTab());

        if(tabHost.getCurrentTab()==0)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab());
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab());
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(0x0000FF00);

    }*/

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
