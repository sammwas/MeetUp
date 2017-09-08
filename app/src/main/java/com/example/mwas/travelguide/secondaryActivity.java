package com.example.mwas.travelguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class secondaryActivity extends AppCompatActivity {
    @Bind(R.id.secondaryActivityTitle) TextView mSecondaryActivityTitle;
    @Bind(R.id.listActivity) ListView mListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);
        ButterKnife.bind(this);
    }
}
