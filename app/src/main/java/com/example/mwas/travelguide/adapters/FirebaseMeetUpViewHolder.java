package com.example.mwas.travelguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mwas.travelguide.Constants;
import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.ui.MeetUpDetailActivity;
import com.example.mwas.travelguide.util.ItemTouchHelperViewHolder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by mwas on 9/22/17.
 */

public class FirebaseMeetUpViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    View mView;
    Context mContext;
    public ImageView mDragIcon;

    public FirebaseMeetUpViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();

    }

    public void bindMeetUp(MeetUp meetUp){
        mDragIcon = (ImageView) mView.findViewById(R.id.dragIcon);

        TextView nameTextView = (TextView) mView.findViewById(R.id.meetUpNameTextView);
        TextView venueTextView = (TextView) mView.findViewById(R.id.venueTextView);
        TextView addressTextView = (TextView) mView.findViewById(R.id.venueAddressTextView);
        TextView groupNameTextView = (TextView) mView.findViewById(R.id.groupNameTextView);


        nameTextView.setText(meetUp.getName());
        venueTextView.setText(meetUp.getVenue());
        addressTextView.setText(meetUp.getVenue1());
        groupNameTextView.setText(meetUp.getGroup1());
    }

    @Override
    public void onItemSelected() {
        Log.d("Animation", "onItemSelected");
        // we will add animations here
    }

    @Override
    public void onItemClear() {
        Log.d("Animation", "onItemClear");
        // we will add animations here
    }

}
