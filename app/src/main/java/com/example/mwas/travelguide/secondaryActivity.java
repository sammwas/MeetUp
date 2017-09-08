package com.example.mwas.travelguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.layout.simple_list_item_1;

public class secondaryActivity extends AppCompatActivity {
    @Bind(R.id.secondaryActivityTitle) TextView mSecondaryActivityTitle;
    @Bind(R.id.listActivity) ListView mListActivity;
    private String[] mLocations = new String[] {"Kabete","Ngong Rd","Kiambu Rd","Langata","Karen","Mombasa Rd","Upper Hill"};
    private String[] mPlacesToGo = new String[] {"Kereita(zip lining,trekking,cycling)","Paint Ball Kenya(paint balling)","Karura Forest(cycling,trekking)","GP Karting(Go Karting)","Malo Stables(horse riding)","Panari Hotel(ice skating)","Kenya Regiment Club(shooting range)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ButterKnife.bind(this);
        TravelGuideArrayAdapter adapter = new TravelGuideArrayAdapter(this,simple_list_item_1,mLocations,mPlacesToGo);
        mListActivity.setAdapter(adapter);
    }
}
