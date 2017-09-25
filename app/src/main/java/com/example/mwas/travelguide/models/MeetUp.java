package com.example.mwas.travelguide.models;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by mwas on 9/16/17.
 */

@Parcel
public class MeetUp {
     String name;
     String description;
     String venue;
     String venue1;
     String group;
     String group1;
     private String pushId;

    public MeetUp(String name,String description, String venue, String venue1, String group, String group1){
        this.name = name;
        this.description = description;
//        this.mStatus = status;
        this.venue = venue;
        this.venue1 = venue1;
        this.group = group;
        this.group1 = group1;
    }

    //empty meetup constructor needed by the Parceler library
    public MeetUp() {}

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public String getVenue() {
        return venue;
    }

    public String getVenue1() {
       return venue1;
    }

    public String getGroup() {
        return group;
    }

    public String getGroup1(){
        return group1; }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
