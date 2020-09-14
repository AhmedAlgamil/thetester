package com.example.thetester.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SliderAdapter extends FragmentStatePagerAdapter {
    private Fragment[] fr_screens = {};

    public int totals = fr_screens.length;

    public SliderAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        Fragment fr_screen = null;
        for (int i = 0;i<totals;i++) {
            if (position == i) {
                fr_screen = fr_screens[i];
            }
        }

       return fr_screen;
    }

    @Override
    public int getCount() {
        return totals;
    }
}
