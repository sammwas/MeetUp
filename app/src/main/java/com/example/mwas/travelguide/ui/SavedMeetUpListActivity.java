package com.example.mwas.travelguide.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.mwas.travelguide.Constants;
import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.adapters.FirebaseMeetUpListAdapter;
import com.example.mwas.travelguide.adapters.FirebaseMeetUpViewHolder;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.util.OnStartDragListener;
import com.example.mwas.travelguide.util.SimpleItemTouchHelperCallback;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedMeetUpListActivity extends AppCompatActivity implements OnStartDragListener{
    private DatabaseReference mMeetUpReference;
    private FirebaseMeetUpListAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mMeetUpReference = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_MEETUP)
                .child(uid);
        mFirebaseAdapter = new FirebaseMeetUpListAdapter(MeetUp.class, R.layout.meetup_list_item_drag, FirebaseMeetUpViewHolder.class,
                        mMeetUpReference,this,this);


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
