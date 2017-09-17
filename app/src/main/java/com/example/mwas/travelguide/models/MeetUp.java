package com.example.mwas.travelguide.models;

import java.util.ArrayList;

/**
 * Created by mwas on 9/16/17.
 */

public class MeetUp {
    private String mName;
    private String mDescription;
    private String mStatus;
    private String mVenue;
    private String mVenue1;
    private String mGroup;
    private String mGroup1;

    public MeetUp(String name, String description, String venue,String venue1,String group,String group1){
        this.mName = name;
        this.mDescription = description;
//        this.mStatus = status;
        this.mVenue = venue;
        this.mVenue1 = venue1;
        this.mGroup = group;
        this.mGroup1 = group1;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

//    public String getStatus() {
//        return mStatus;
//    }

    public String getVenue() {
        return mVenue;
    }

    public String getVenue1() {
        return mVenue1;
    }

    public String getGroup() {
        return mGroup;
    }

    public String getGroup1(){ return mGroup1; }

}
