package com.runbuddy.runbuddy.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jonney Chou on 2016/7/11.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public MyFragmentPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragmentList) {
        super(fragmentManager);
        if (fragmentList == null) {
            this.fragmentList = new ArrayList<Fragment>();
        } else {
            this.fragmentList = fragmentList;
        }
    }

    @Override
    public Fragment getItem(int position) {
        //return null;
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        //return 0;
        return fragmentList.size();
    }
}
