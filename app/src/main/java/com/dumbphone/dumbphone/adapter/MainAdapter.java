package com.dumbphone.dumbphone.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dumbphone.dumbphone.views.home.AppFragment;
import com.dumbphone.dumbphone.views.home.ExperimentFragment;
import com.dumbphone.dumbphone.views.home.HomeFragment;

public class MainAdapter  extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        switch(pos) {

//            case 0: return HomeFragment.newInstance("FirstFragment, Instance 1");
            case 0: return HomeFragment.newInstance("FirstFragment, Default");
            case 1: return AppFragment.newInstance("SecondFragment, Instance 1");
            default: return ExperimentFragment.newInstance("ThirdFragment, Instance 1");

        }
    }


    @Override
    public int getCount() {
        return 3;
    }
}