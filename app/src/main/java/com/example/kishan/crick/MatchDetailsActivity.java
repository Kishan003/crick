package com.example.kishan.crick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MatchDetailsActivity extends AppCompatActivity {

    private Matches matchdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);

        if(getIntent().hasExtra("match")){
            matchdetails= getIntent().getParcelableExtra("match");
            Log.d("MatchDetailsActivity", matchdetails.toString());


        }

    }


}
