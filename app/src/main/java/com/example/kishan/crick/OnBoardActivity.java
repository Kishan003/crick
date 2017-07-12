package com.example.kishan.crick;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OnBoardActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private Button sign;
    private boolean isFrom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_board);
        if(getIntent()!=null) {
            isFrom = getIntent().getBooleanExtra("isSignup", false);
        }
        if(isFrom){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            LogInFragment loginFragment = new LogInFragment();
            fragmentTransaction.add(R.id.fragment_container, loginFragment);
            fragmentTransaction.commit();
        }
        else{
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SignUpFragment signupFragment = new SignUpFragment();
            fragmentTransaction.replace(R.id.fragment_container, signupFragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onClick(View view) {

    }
}
