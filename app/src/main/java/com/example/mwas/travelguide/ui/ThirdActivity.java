package com.example.mwas.travelguide.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.adapters.MeetUpListAdapter;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.services.MeetUpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;


import okhttp3.Callback;
import okhttp3.Response;

public class ThirdActivity extends AppCompatActivity {
    public static final String TAG = ThirdActivity.class.getSimpleName();
    public ArrayList<MeetUp> mMeetUps = new ArrayList<>();
    private MeetUpListAdapter mAdapter;
//    @Bind(R.id.meetUpListActivity) ListView mMeetUpListActivity;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        getMeetUp();
    }

    private void getMeetUp() {
        final MeetUpService meetUpService = new MeetUpService();
        meetUpService.findMeetUp(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mMeetUps = meetUpService.processResults(response);
                ThirdActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new MeetUpListAdapter(getApplicationContext(), mMeetUps);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(ThirdActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                        for (MeetUp meetUp : mMeetUps) {

                            Log.d(TAG, "name: " + meetUp.getName());
                            Log.d(TAG, "description: " + meetUp.getDescription());
                            Log.d(TAG, "venue: " + meetUp.getVenue().toString());
                            Log.d(TAG, "venue1:" + meetUp.getVenue1().toString());
                            Log.d(TAG, "group:" + meetUp.getGroup().toString());
                            Log.d(TAG, "group1:" + meetUp.getGroup1().toString());
                        }
                    }
                });
            }


        });
    }
}
