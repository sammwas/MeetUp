package com.example.mwas.travelguide.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mwas.travelguide.Constants;
import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.adapters.FirebaseMeetUpViewHolder;
import com.example.mwas.travelguide.models.MeetUp;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedMeetUpListActivity extends AppCompatActivity {
    private DatabaseReference mMeetUpReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        mMeetUpReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_MEETUP);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<MeetUp, FirebaseMeetUpViewHolder>
                (MeetUp.class, R.layout.meetup_list_item, FirebaseMeetUpViewHolder.class,
                        mMeetUpReference) {

            @Override
            protected void populateViewHolder(FirebaseMeetUpViewHolder viewHolder,
                                              MeetUp model, int position) {
                viewHolder.bindMeetUp(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
