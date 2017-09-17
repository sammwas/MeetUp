package com.example.mwas.travelguide.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mwas.travelguide.R;
import com.example.mwas.travelguide.models.MeetUp;
import com.example.mwas.travelguide.services.MeetUpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class secondaryActivity extends AppCompatActivity {
    @Bind(R.id.secondaryActivityTitle) TextView mSecondaryActivityTitle;
    @Bind(R.id.listActivity) ListView mListActivity;

    public static final String TAG = secondaryActivity.class.getSimpleName();
    public ArrayList<MeetUp> mMeetUps = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ButterKnife.bind(this);
        mSecondaryActivityTitle.setText("Checkout the following meet-ups in your area");
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
                        secondaryActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                String[] meetUpNames = new String[mMeetUps.size()];
                                for(int i=0; i<meetUpNames.length; i++){
                                    meetUpNames[i] = mMeetUps.get(i).getName();
                                }
                                ArrayAdapter adapter = new ArrayAdapter(secondaryActivity.this,android.R.layout.simple_list_item_1,meetUpNames);
                                mListActivity.setAdapter(adapter);
                                for (MeetUp meetUp : mMeetUps) {
                                    Log.d(TAG, "name: " + meetUp.getName());
                                    Log.d(TAG, "description: " + meetUp.getDescription());
//                                    Log.d(TAG, "status: " + meetUp.getStatus());
                                    Log.d(TAG, "venue: " + meetUp.getVenue().toString());
                                    Log.d(TAG, "group:" + meetUp.getGroup().toString());
                                }
                            }
                        });
                    }


        });
    }




}
