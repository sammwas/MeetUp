package com.example.mwas.travelguide.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.ui.MeetUpDetailActivity;
import com.example.mwas.travelguide.util.ItemTouchHelperAdapter;
import com.example.mwas.travelguide.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mwas on 9/29/17.
 */

public class FirebaseMeetUpListAdapter extends FirebaseRecyclerAdapter<MeetUp, FirebaseMeetUpViewHolder>  implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener  mChildEventListener;
    private ArrayList<MeetUp> mMeetUps = new ArrayList<>();

    public FirebaseMeetUpListAdapter(Class<MeetUp> modelClass, int modelLayout,
                                     Class<FirebaseMeetUpViewHolder> viewHolderClass,
                                     Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mMeetUps.add(dataSnapshot.getValue(MeetUp.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    protected void populateViewHolder(final FirebaseMeetUpViewHolder viewHolder, MeetUp model, int position) {
        viewHolder.bindMeetUp(model);
        viewHolder.mDragIcon.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MeetUpDetailActivity.class);
                intent.putExtra("position", viewHolder.getAdapterPosition());
                intent.putExtra("meetUps", Parcels.wrap(mMeetUps));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mMeetUps, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mMeetUps.remove(position);
        getRef(position).removeValue();
    }

    private void setIndexInFirebase() {
        for (MeetUp meetUp : mMeetUps) {
            int index = mMeetUps.indexOf(meetUp);
            DatabaseReference ref = getRef(index);
            meetUp.setIndex(Integer.toString(index));
            ref.setValue(meetUp);
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        setIndexInFirebase();
        mRef.removeEventListener(mChildEventListener);
    }
}
