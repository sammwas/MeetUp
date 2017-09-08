package com.example.mwas.travelguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.findActivityButton) Button findActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
