package com.example.mwas.travelguide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.ui.MeetUpDetailFragment;

import java.util.ArrayList;

/**
 * Created by mwas on 9/21/17.
 */

public class MeetUpPageAdapter extends FragmentPagerAdapter {
    private ArrayList<MeetUp> mMeetUps;

    public MeetUpPageAdapter(FragmentManager fm, ArrayList<MeetUp> meetUps){
        super(fm);
        mMeetUps = meetUps;
    }

    @Override
    public Fragment getItem(int position) {
        return MeetUpDetailFragment.newInstance(mMeetUps.get(position));
    }

    @Override
    public int getCount()  {
        return mMeetUps.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMeetUps.get(position).getName();
    }
}
