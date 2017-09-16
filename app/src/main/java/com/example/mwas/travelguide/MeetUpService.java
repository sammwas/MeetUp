package com.example.mwas.travelguide;

import android.util.Log;

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
                    String status = meetingJSON.getString("status");
                    String description = meetingJSON.getString("description");

                    ArrayList<String> venue = new ArrayList<>();
                    JSONArray venueJSON = meetingJSON.getJSONArray("venue");
                    for (int y = 0; y < venueJSON.length(); y++) {
                        venue.add(venueJSON.getJSONArray(y).toString());
                    }

                    ArrayList<String> group = new ArrayList<>();
                    JSONArray groupJSON = meetingJSON.getJSONArray("group");
                    for (int y = 0; y < groupJSON.length(); y++) {
                        group.add(groupJSON.getJSONArray(y).toString());
                    }
                    MeetUp meetUp = new MeetUp(name, status, description, venue, group);
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
