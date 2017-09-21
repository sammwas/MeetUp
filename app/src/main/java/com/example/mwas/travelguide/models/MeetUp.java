package com.example.mwas.travelguide.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by mwas on 9/16/17.
 */

@Parcel
public class MeetUp {
    private String mName;
    private String mDescription;
    private String mVenue;
    private String mVenue1;
    private String mGroup;
    private String mGroup1;

    public MeetUp(String name,String description, String venue, String venue1, String group, String group1){
        this.mName = name;
        this.mDescription = description;
//        this.mStatus = status;
        this.mVenue = venue;
        this.mVenue1 = venue1;
        this.mGroup = group;
        this.mGroup1 = group1;
    }

    //empty meetup constructor needed by the Parceler library
    public MeetUp() {}

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }


    public String getVenue() {
        return mVenue;
    }

    public String getVenue1() {
       return mVenue1;
    }

    public String getGroup() {
        return mGroup;
    }

    public String getGroup1(){
        return mGroup1; }

}
