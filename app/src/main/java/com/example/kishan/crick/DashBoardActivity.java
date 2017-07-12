package com.example.kishan.crick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardActivity extends AppCompatActivity {
    String api_key = "bDE5UTFctodGJBc2s1CdVpu367C3";
    private ArrayList<Data.Matches> matches= new ArrayList<>() ;
    DataAdapter dataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataAdapter = new DataAdapter(matches);
        recyclerView.setAdapter(dataAdapter);




        retrofit2.Call<Data> call = new RetrofitClass().getService().getmatches(api_key);

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(retrofit2.Call<Data> call, Response<Data> response) {
                Log.d("response",response.body().getMatches().toString());
                matches.addAll(response.body().getMatches());
                dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(retrofit2.Call<Data> call, Throwable t) {
                Log.d("api","failed hi hello");

            }
        });
    }
}
