package com.example.mwas.travelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.findActivityButton) Button mFindActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindActivityButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, secondaryActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
