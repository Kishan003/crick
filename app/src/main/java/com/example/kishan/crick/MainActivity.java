package com.example.kishan.crick;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private Button signup;
    SharedPreferences sharedPreferences;
    private String email;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        login = (Button) findViewById(R.id.login_btn);
        signup = (Button) findViewById(R.id.signup_btn);
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
        sharedPreferences = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        Intent intent;
        if(!TextUtils.isEmpty(email)){
             intent = new Intent(MainActivity.this, DashBoardActivity.class);
            startActivity(intent);}
//        }else {
//            intent = new Intent(MainActivity.this, OnBoardActivity.class);
//            startActivity(intent);
//        }




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
