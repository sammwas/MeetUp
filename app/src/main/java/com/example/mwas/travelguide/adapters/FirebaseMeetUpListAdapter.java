package com.example.mwas.travelguide.adapters;

import android.content.Context;

import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.util.ItemTouchHelperAdapter;
import com.example.mwas.travelguide.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by mwas on 9/29/17.
 */

public class FirebaseMeetUpListAdapter extends FirebaseRecyclerAdapter<MeetUp, FirebaseMeetUpViewHolder>  implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebaseMeetUpListAdapter(Class<MeetUp> modelClass, int modelLayout,
                                     Class<FirebaseMeetUpViewHolder> viewHolderClass,
                                     Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    protected void populateViewHolder(FirebaseMeetUpViewHolder viewHolder, MeetUp model, int position) {
        viewHolder.bindMeetUp(model);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
