package com.example.kishan.crick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        login = (Button) findViewById(R.id.login_btn);
        signup = (Button) findViewById(R.id.signup_btn);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent1 = new Intent(MainActivity.this, OnBoardActivity.class);
        if(view.getId()== R.id.login_btn){

            intent1.putExtra("isSignup", true);

            startActivity(intent1);
        }

        else{
            intent1.putExtra("isSignup", false);

            startActivity(intent1);

        }
    }
}
