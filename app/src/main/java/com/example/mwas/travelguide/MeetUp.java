package com.example.mwas.travelguide;

import java.util.ArrayList;

/**
 * Created by mwas on 9/16/17.
 */

public class MeetUp {
    private String mName;
    private String mDescription;
    private String mStatus;
    private ArrayList<String> mVenue = new ArrayList<>();
    private ArrayList<String> mGroup = new ArrayList<>();

    public MeetUp(String name, String description, String status, ArrayList<String> venue,ArrayList<String> group){
        this.mName = name;
        this.mDescription = description;
        this.mStatus = status;
        this.mVenue = venue;
        this.mGroup = group;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getStatus() {
        return mStatus;
    }

    public ArrayList<String> getVenue() {
        return mVenue;
    }

    public ArrayList<String> getGroup() {
        return mGroup;
    }
}
