package com.project.mad.fincheck;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by SAHAJA on 14-03-2018.
 */

public class ContentFragmentAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "INSERT", "DAILY", "ANALYSIS" };

    public ContentFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
            return RepCharty.newInstance(position+1);
        else if(position==1)
            return BarCharty.newInstance(position+1);
        else
            return PieCharty.newInstance(position+1);

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  tabTitles[position];
    }
}