package com.example.mwas.travelguide.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUp;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mwas on 9/18/17.
 */

public class MeetUpListAdapter extends RecyclerView.Adapter<MeetUpListAdapter.ViewHolder>{
    private ArrayList<MeetUp> mMeetUps = new ArrayList<>();
    private Context mContext;

    public MeetUpListAdapter(Context context, ArrayList<MeetUp> meetUps){
        mContext = context;
        mMeetUps = meetUps;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.meetUpNameTextView) TextView mMeetUpNameTextView;
        @Bind(R.id.venueTextView) TextView mVenueTextView;
        @Bind(R.id.venueAddressTextView) TextView mVenueAddressTextView;
        @Bind(R.id.groupNameTextView) TextView mGroupNameTextView;

        private Context mContext;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();

        }

        public void bindMeetUp(MeetUp meetUp) {
            mMeetUpNameTextView.setText(meetUp.getName());
            mVenueTextView.setText(meetUp.getVenue());
            mVenueAddressTextView.setText(meetUp.getVenue1());
            mGroupNameTextView.setText(meetUp.getGroup1());

        }
    }
}
