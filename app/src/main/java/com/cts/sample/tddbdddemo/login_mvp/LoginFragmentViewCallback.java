package com.cts.sample.tddbdddemo.login_mvp;

/**
 * Created by shanmg02 on 11/09/2015.
 */
public interface LoginFragmentViewCallback {

    void showProgress();

    void endProgress();

    void onLoginSuccess();

    void onLoginFailed();

}
