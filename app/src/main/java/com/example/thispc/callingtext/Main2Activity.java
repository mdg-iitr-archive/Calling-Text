package com.example.thispc.callingtext;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class Main2Activity extends TabActivity implements TabHost.OnTabChangeListener{
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main2);
        tabHost = getTabHost();
        tabHost.setOnTabChangedListener(this);

        TabHost.TabSpec spec;
        Intent intent;
        intent = new Intent().setClass(this, GifActivity.class);
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
        tabHost.getTabWidget().getChildAt(0);
    }
    @Override
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
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(0x0000FF00);
        else if(tabHost.getCurrentTab()==1)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(0x0000FF00);
        else if(tabHost.getCurrentTab()==2)
            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(0x0000FF00);

    }
}
