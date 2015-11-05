package com.cts.sample.tddbdddemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.cts.sample.tddbdddemo.dialogs.AlertDialogFragment;
import com.cts.sample.tddbdddemo.introscreen.WelcomeFragment;
import com.cts.sample.tddbdddemo.login.LoginFragmentView;
import com.cts.sample.tddbdddemo.urlfetch.LandingFragment;

public class MainActivity extends FragmentActivity
    implements WelcomeFragment.OnWelcomeFragmentInteractionListener,
    LoginFragmentView.OnLoginListener, LandingFragment.OnLandingFragmentListener{

    public static final String APP_PREFS = "AppPrefs";
    public static final String SESSION_START_TS = "session_start_ts";
    public static final long SESSION_VALIDITY = 1000 * 60 * 60;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (isSessionValid()) {
            showLandingFragment();
        } else {
            deleteSession();
            showWelcomeFragment();
        }

    }



    private void showWelcomeFragment() {
        WelcomeFragment welcomeFragment = new WelcomeFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().getFragments() != null
                && getSupportFragmentManager().getFragments().size() > 0 )
            ft.replace(R.id.fragment_container, welcomeFragment);
        else
            ft.add(R.id.fragment_container, welcomeFragment);

        ft.commit();
    }

    private void showLoginFragment() {
        LoginFragmentView loginFragment = new LoginFragmentView();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, loginFragment);

        ft.commit();
    }

    private void showLandingFragment() {
        LandingFragment landingFragment = new LandingFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().getFragments() != null
                && getSupportFragmentManager().getFragments().size() > 0 )
            ft.replace(R.id.fragment_container, landingFragment);
        else
            ft.add(R.id.fragment_container, landingFragment);

        ft.commit();
    }

    @Override
    public void onLoginButtonClicked() {
        showLoginFragment();
    }

    @Override
    public void onRegisterButtonClicked() {
        //Nothing to do
    }

    @Override
    public void onLoggedIn() {
        String currTimeStamp = String.valueOf(System.currentTimeMillis());
        createSession(currTimeStamp);
        showLandingFragment();
    }

    @Override
    public void onLogInFailed() {
        showdialog();
    }

    @Override
    public void onLogout() {
        deleteSession();
        showWelcomeFragment();
    }

    private void showdialog() {
        AlertDialogFragment alertDialog = new AlertDialogFragment();
        alertDialog.show(getSupportFragmentManager(), "AlertDialogFragment");
    }

    /************** Session Handling ******************/

    private void createSession(String timeStampInMillis) {
        if(timeStampInMillis != null && !timeStampInMillis.isEmpty()) {
            setSessionStartTime(timeStampInMillis);
        }
    }

    private void deleteSession() {
        SharedPreferences prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.remove(SESSION_START_TS);
        editor.commit();
    }

    private boolean isSessionValid() {
        SharedPreferences prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);

        String strTimeStamp = prefs.getString(SESSION_START_TS, "0ms");
        strTimeStamp = strTimeStamp.substring(0, strTimeStamp.indexOf("ms"));

        boolean session_valid = false;
        if(!strTimeStamp.isEmpty()) {
            long startTS = Long.valueOf(strTimeStamp).longValue();
            long currTS = System.currentTimeMillis();
            session_valid = (currTS - startTS) < SESSION_VALIDITY ? true : false;
        }

        return session_valid;
    }

    public void setSessionStartTime(String timeStampInMillis) {
        SharedPreferences prefs = getSharedPreferences(APP_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString(SESSION_START_TS, timeStampInMillis+"ms");
        editor.commit();
    }
}
