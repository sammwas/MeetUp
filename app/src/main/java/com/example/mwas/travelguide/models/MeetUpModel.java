package com.example.mwas.travelguide.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mwas on 9/17/17.
 */

public class MeetUpModel {
    @SerializedName("name")
    private String mName;
    @SerializedName("description")
    private String mDescription;


    public MeetUpModel(String name, String description) {
        this.mName = name;
        this.mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

}
