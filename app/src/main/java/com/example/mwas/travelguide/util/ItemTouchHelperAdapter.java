package com.example.mwas.travelguide.util;

/**
 * Created by mwas on 9/29/17.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
