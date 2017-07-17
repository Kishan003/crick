package com.example.kishan.crick;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LogInFragment extends Fragment implements View.OnClickListener{
    private EditText emailText;
    private EditText passwordText;
    private SharedPreferences sharedPreferences;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button login = (Button) view.findViewById(R.id.login_btn);
        login.setOnClickListener(this);
        emailText = (EditText) view.findViewById(R.id.email);
        passwordText = (EditText) view.findViewById(R.id.password);
        sharedPreferences = getActivity().getSharedPreferences(getActivity().getPackageName(), Activity.MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        sharedPreferences.edit().putString("email", emailText.getText().toString()).apply();
        sharedPreferences.edit().putString("password", passwordText.getText().toString()).apply();
        Intent intent = new Intent(getActivity(), DashBoardActivity.class);
        startActivity(intent);


    }

}
