package com.example.mwas.travelguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.ui.MeetUpDetailActivity;

import org.parceler.Parcels;

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

    @Override
    public MeetUpListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meetup_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MeetUpListAdapter.ViewHolder holder, int position){
        holder.bindMeetUp(mMeetUps.get(position));
    }
    @Override
    public int getItemCount() {
        return mMeetUps.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        @Bind(R.id.meetUpNameTextView) TextView mMeetUpNameTextView;
        @Bind(R.id.venueTextView) TextView mVenueTextView;
        @Bind(R.id.venueAddressTextView) TextView mVenueAddressTextView;
        @Bind(R.id.groupNameTextView) TextView mGroupNameTextView;

        private Context mContext;

        public ViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent  =  new Intent(mContext, MeetUpDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("meetUps", Parcels.wrap(mMeetUps));
            mContext.startActivity(intent);
        }
        public void bindMeetUp(MeetUp meetUp) {
            mMeetUpNameTextView.setText(meetUp.getName());
            mVenueTextView.setText(meetUp.getVenue());
            mVenueAddressTextView.setText(meetUp.getVenue1());
            mGroupNameTextView.setText(meetUp.getGroup1());

        }
    }
}
