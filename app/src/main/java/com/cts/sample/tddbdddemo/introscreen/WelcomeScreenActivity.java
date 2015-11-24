package com.cts.sample.tddbdddemo.introscreen;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.cts.sample.tddbdddemo.R;
import com.cts.sample.tddbdddemo.collectionmanagement.CollectionModel;
import com.cts.sample.tddbdddemo.introscreen.WelcomeFragment.OnWelcomeFragmentInteractionListener;
import com.google.gson.Gson;


public class WelcomeScreenActivity extends FragmentActivity
        implements OnWelcomeFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showWelcomeFragment();

        Gson gson = new Gson();

        // convert java object to JSON format,
        // and returned as JSON formatted string
        String json = gson.toJson(new CollectionModel(10));
        System.out.println("JSON::"+json);

    }


    private void showWelcomeFragment() {
        WelcomeFragment welcomeFragment = new WelcomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, welcomeFragment);
        ft.commit();
    }

    @Override
    public void onLoginButtonClicked() {
        Toast.makeText(this, "called", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRegisterButtonClicked() {

    }


}
