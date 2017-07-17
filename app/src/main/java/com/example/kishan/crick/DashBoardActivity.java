package com.example.kishan.crick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = DashBoardActivity.class.getSimpleName();
    String api_key = "bDE5UTFctodGJBc2s1CdVpu367C3";
    private ArrayList<Matches> matches= new ArrayList<>() ;
    DataAdapter dataAdapter;
    private SharedPreferences sharedPreferences;
    private String email,password;
    private Button logout;
    public int uid;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataAdapter = new DataAdapter(matches, new DataAdapter.OnmatchClickListener() {

            @Override
            public void onMatchClicked(int i) {
                Intent intent = new Intent(DashBoardActivity.this, MatchDetailsActivity.class);
                intent.putExtra("match", matches.get(i));
                startActivity(intent);


            }
        });
        recyclerView.setAdapter(dataAdapter);

        sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        email= sharedPreferences.getString("email","");
        password= sharedPreferences.getString("password", "");
        Log.d(TAG, "email:"+email+ "password:"+ password);





        retrofit2.Call<Data> call = new RetrofitClass().getService().getmatches(api_key);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(retrofit2.Call<Data> call, Response<Data> response) {
                Log.d("response",response.body().getMatches().toString());
                matches.addAll(response.body().getMatches());
                dataAdapter.notifyDataSetChanged();
                response.toString();
            }

            @Override
            public void onFailure(retrofit2.Call<Data> call, Throwable t) {
                Log.d("api","failed hi hello");

            }


        });

    }
    public void onClick(View view){
        Intent intent;


        switch (view.getId()){

            case R.id.logout:
                intent = new Intent(DashBoardActivity.this, MainActivity.class);
                startActivity(intent);
                sharedPreferences.edit().clear().apply();
                finish();
                break;

        }



        }



    }

