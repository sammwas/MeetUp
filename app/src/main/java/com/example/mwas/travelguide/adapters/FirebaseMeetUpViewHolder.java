package com.example.mwas.travelguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.mwas.travelguide.Constants;
import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.ui.MeetUpDetailActivity;
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

public class FirebaseMeetUpViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseMeetUpViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);

    }

    public void bindMeetUp(MeetUp meetUp){
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
    public void onClick(View view) {
        final ArrayList<MeetUp> meetUps = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MEETUP);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    meetUps.add(snapshot.getValue(MeetUp.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, MeetUpDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("meetUps", Parcels.wrap(meetUps));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

}
