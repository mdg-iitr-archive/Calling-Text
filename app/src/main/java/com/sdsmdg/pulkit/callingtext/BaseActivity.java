package com.sdsmdg.pulkit.callingtext;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.Toast;

public class BaseActivity extends FragmentActivity implements ActionBar.TabListener,GifFragment.onImageselectionListener {

    TabHost tabHost;
    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    FragmentManager fragmentManager;
    GifFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);
       /* actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);*/
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tabLayout.setTabTextColors();
             tabLayout.setupWithViewPager(viewPager);


//        Intent intent = new Intent(this, BackGroundWorker.class);
//        startService(intent);
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
        Log.e("in null","in null");
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
