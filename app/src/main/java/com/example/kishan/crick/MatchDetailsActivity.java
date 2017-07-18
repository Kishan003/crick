package com.example.kishan.crick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MatchDetailsActivity extends AppCompatActivity {

    private Matches matchdetails;
    private TextView team1;
    private TextView date;
    private String date1;
    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);

        date = (TextView) findViewById(R.id.date);
        team1= (TextView) findViewById(R.id.team1);
        status= (TextView) findViewById(R.id.Status);




        if(getIntent().hasExtra("match")){
            matchdetails= getIntent().getParcelableExtra("match");
            Log.d("MatchDetailsActivity", matchdetails.toString());
            date.setText("Matchis on:"+ matchdetails.getDate());
            team1.setText("Teams:"+matchdetails.getTeam1()+"V/S"+matchdetails.getTeam2());
            status.setText("Match started:"+matchdetails.isMatchStarted());

        }

    }


}
