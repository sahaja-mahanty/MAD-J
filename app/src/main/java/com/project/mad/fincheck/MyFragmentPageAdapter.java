package com.project.mad.fincheck;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SAHAJA on 13-03-2018.
 */



public class MyFragmentPageAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Insert", "Daily", "Analysis" };

    public MyFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return InsertFragment.newInstance(position+1);
        else if(position==1)
            return DayFragment.newInstance(position+1);
        else
            return IndWeakFragment.newInstance(position+1);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
