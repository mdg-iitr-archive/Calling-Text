package com.sdsmdg.pulkit.callingtext;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.TabHost;

public class Main2Activity extends FragmentActivity implements ActionBar.TabListener {
    TabHost tabHost;
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    private String[] tabs = {"History", "Contacts", "New"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
       /* tabHost = getTabHost();
        tabHost.setOnTabChangedListener(this);
        TabHost.TabSpec spec;
        Intent intent;
        intent = new Intent().setClass(this, History.class);
        spec = tabHost.newTabSpec("History").setIndicator("History")
                .setContent(intent);
        tabHost.addTab(spec);
        intent = new Intent().setClass(this, ContactList.class);
        spec = tabHost.newTabSpec("Contacts").setIndicator("Contacts")
                .setContent(intent);
        tabHost.addTab(spec);
        intent = new Intent().setClass(this, MainActivity.class);
        spec = tabHost.newTabSpec("New").setIndicator("New")
                .setContent(intent);
        tabHost.addTab(spec);
        tabHost.getTabWidget().getChildAt(1);
        TextView tv = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title); //Unselected Tabs
        tv.setTextSize(17);
        tv.setTextColor(Color.parseColor("#ffffff"));
        tabHost.getTabWidget().getChildAt(2);
        TextView tv1 = (TextView) tabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title); //Unselected Tabs
        tv.setTextSize(17);
        tv.setTextColor(Color.parseColor("#ffffff"));
        tabHost.getTabWidget().setCurrentTab(0);
        tabHost.getTabWidget().getChildAt(0);*/
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
}