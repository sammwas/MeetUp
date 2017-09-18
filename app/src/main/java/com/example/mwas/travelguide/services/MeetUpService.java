package com.example.mwas.travelguide.services;

import android.util.Log;

import com.example.mwas.travelguide.Constants;
import com.example.mwas.travelguide.models.MeetUp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by mwas on 9/15/17.
 */

public class MeetUpService {
    public static void findMeetUp(Callback callback) {
        //construct a url for
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MEETUP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_QUERY_PARAM, Constants.API_KEY);
        String url = urlBuilder.build().toString();

        Log.v("try url", url);

        //create a client
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
            call.enqueue(callback);

    }

    public ArrayList<MeetUp> processResults(Response response) {
        ArrayList<MeetUp> meetUps = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject meetUpJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = meetUpJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject meetingJSON = resultsJSON.getJSONObject(i);

                    String name = meetingJSON.getString("name");

                    String description = meetingJSON.optString("description");

                    String venue = "";
                    if(meetingJSON.has("venue")) {
                        venue = meetingJSON.getJSONObject("venue").getString("name");
                    }

                    String venue1="";
                    if(meetingJSON.has("venue")) {
                        venue1 = meetingJSON.getJSONObject("venue").getString("address_1");
                    }

                    String group="";
                    if(meetingJSON.has("group")) {
                        group = meetingJSON.getJSONObject("group").getString("join_mode");
                    }

                    String group1="";
                    if(meetingJSON.has("group")) {
                        group1 = meetingJSON.getJSONObject("group").getString("name");
                    }

                        MeetUp meetUp = new MeetUp(name, description, venue, venue1, group, group1);

                    meetUps.add(meetUp);
                }
            }
            }catch(IOException e){
                e.printStackTrace();
            }catch(JSONException e){
                e.printStackTrace();
            }
            return meetUps;

        }
}
