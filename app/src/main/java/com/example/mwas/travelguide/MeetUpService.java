package com.example.mwas.travelguide;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by mwas on 9/15/17.
 */

public class MeetUpService {
    public static void findMeetUp(Callback callback) {
        //create a client
        OkHttpClient client = new OkHttpClient();
        //construct a url for
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MEETUP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_KEY,BuildConfig.API_KEY);
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
            call.enqueue(callback);

    }
}
