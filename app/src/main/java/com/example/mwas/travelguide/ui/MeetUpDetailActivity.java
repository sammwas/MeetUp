package com.example.mwas.travelguide.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.adapters.MeetUpPageAdapter;
import com.example.mwas.travelguide.models.MeetUp;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MeetUpDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private MeetUpPageAdapter adapterViewPager;
    ArrayList<MeetUp> mMeetUps = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_up_detail);
        ButterKnife.bind(this);

        mMeetUps = Parcels.unwrap(getIntent().getParcelableExtra("meetUps"));
        int startingPosition = getIntent().getIntExtra("position", 0);
        adapterViewPager = new MeetUpPageAdapter(getSupportFragmentManager(),mMeetUps);

        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
