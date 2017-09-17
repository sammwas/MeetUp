package com.example.mwas.travelguide.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUpModel;
import com.example.mwas.travelguide.models.MeetUpModelResponse;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.rest.ApiInterface;
import com.example.mwas.travelguide.services.ApiClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class secondaryActivity extends AppCompatActivity {
    @Bind(R.id.secondaryActivityTitle) TextView mSecondaryActivityTitle;
    @Bind(R.id.listActivity) ListView mListActivity;

    public static final String TAG = secondaryActivity.class.getSimpleName();
    public ArrayList<MeetUp> mMeetUps = new ArrayList<>();
    private final static String API_KEY = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ButterKnife.bind(this);
        mSecondaryActivityTitle.setText("Checkout the following meet-ups in your area");

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MeetUpModelResponse> call = apiService.getConcierge(API_KEY);
        call.enqueue(new Callback<MeetUpModelResponse>() {
            @Override
            public void onResponse(Call<MeetUpModelResponse>call, Response<MeetUpModelResponse> response) {
                List<MeetUpModel> results = response.body().getResults();
                Log.d(TAG, "Here are the events found: " + results.size());
            }

            @Override
            public void onFailure(Call<MeetUpModelResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    }







