package com.example.mwas.travelguide.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mwas.travelguide.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.locationEditText) EditText mLocationEditText;
    @Bind(R.id.findActivityButton) Button mFindActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFindActivityButton.setOnClickListener(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Enlighten your Destiny.ttf");
        mAppNameTextView.setTypeface(typeface);

    }



    public void onClick(View face){
        if(face == mFindActivityButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, secondaryActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }

}

