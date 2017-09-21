package com.example.mwas.travelguide.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUp;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MeetUpDetailFragment extends Fragment {
    @Bind(R.id.meetUpNameTextView) TextView mMeetUpNameTextView;
    @Bind(R.id.venueTextView) TextView mVenueTextView;
    @Bind(R.id.venueAddressTextView) TextView mVenueAddressTextView;
    @Bind(R.id.groupNameTextView) TextView mGroupNameTextView;

    private MeetUp mMeetUp;

    public static MeetUpDetailFragment newInstance(MeetUp meetUp) {
        MeetUpDetailFragment meetUpDetailFragment = new MeetUpDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("meetUp", Parcels.wrap(meetUp));
        meetUpDetailFragment.setArguments(args);
        return meetUpDetailFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMeetUp = Parcels.unwrap(getArguments().getParcelable("restaurant"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meet_up_detail,container,false);
        ButterKnife.bind(this,view);
        mMeetUpNameTextView.setText(mMeetUp.getName());
        mVenueTextView.setText(mMeetUp.getVenue());
        mVenueAddressTextView.setText(mMeetUp.getVenue1());
        mGroupNameTextView.setText(mMeetUp.getGroup1());
        return view;

    }

}
