package com.example.mwas.travelguide;


import android.content.Context;
import android.widget.ArrayAdapter;

public class TravelGuideArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mLocations;
    private String[] mPlacesToGo;

    public TravelGuideArrayAdapter(Context context,int resource,String[] locations,String[] placesToGo) {
        super(context,resource);
        this.mContext = context;
        this.mLocations = locations;
        this.mPlacesToGo = placesToGo;
    }
    @Override
    public int getCount() {
        return mLocations.length;
    }

    @Override
    public Object getItem(int position) {
        String location = mLocations[position];
        String placeToGo = mPlacesToGo[position];
        return String.format("%s \nlocated at: %s",placeToGo,location);
    }

}
