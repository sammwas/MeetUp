package com.example.mwas.travelguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.R.layout.simple_list_item_1;

public class secondaryActivity extends AppCompatActivity {
    @Bind(R.id.secondaryActivityTitle) TextView mSecondaryActivityTitle;
    @Bind(R.id.listActivity) ListView mListActivity;

    public static final String TAG = secondaryActivity.class.getSimpleName();

    private String[] mLocations = new String[] {"Kabete","Ngong Rd","Kiambu Rd","Langata","Karen","Mombasa Rd","Upper Hill"};
    private String[] mPlacesToGo = new String[] {"Kereita(zip lining,trekking,cycling)","Paint Ball Kenya(paint balling)","Karura Forest(cycling,trekking)","GP Karting(Go Karting)","Malo Stables(horse riding)","Panari Hotel(ice skating)","Kenya Regiment Club(shooting range)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ButterKnife.bind(this);
        TravelGuideArrayAdapter adapter = new TravelGuideArrayAdapter(this,simple_list_item_1,mLocations,mPlacesToGo);
        mListActivity.setAdapter(adapter);
        mListActivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String place = ((TextView)view).getText().toString();
                Toast.makeText(secondaryActivity.this, place, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getMeetUp() {
        MeetUpService meetUpService = new MeetUpService();
        meetUpService.findMeetUp(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
