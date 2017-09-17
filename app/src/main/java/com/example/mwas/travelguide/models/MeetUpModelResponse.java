package com.example.mwas.travelguide.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mwas on 9/17/17.
 */

public class MeetUpModelResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<MeetUpModel> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MeetUpModel> getResults() {
        return results;
    }

    public void setResults(List<MeetUpModel> results) {
        this.results = results;
    }
}
