package com.sdsmdg.pulkit.callingtext;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new ContactList();
            case 1:
                return new History();
            case 2:
                return new MainActivity();
        }

        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Contacts";
            case 1:
                return "History";
            case 2:
                return "New";
        }
        return null;
    }
    @Override
    public int getCount() {
        return 3;
    }

}
