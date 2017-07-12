package com.example.kishan.crick;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements View.OnClickListener{

    private Button signup;
    private TextView login;
    public final static String TAG = SignUpFragment.class.getSimpleName();
    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signup = (Button) view.findViewById(R.id.signup_btn);
        login = (TextView) view.findViewById(R.id.login);
        signup.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup_btn:
                Intent intent = new Intent(getActivity(), DashBoardActivity.class);
                Log.d(TAG,"sign up");
                startActivity(intent);
                break;
            case R.id.login:
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                LogInFragment loginFragment = new LogInFragment();
                fragmentTransaction.add(R.id.fragment_container, loginFragment);
                fragmentTransaction.commit();
                Log.d(TAG,"login");
                break;

        }

    }
}
