package com.cts.sample.tddbdddemo.login;

/**
 * Created by shanmg02 on 11/09/2015.
 */
public class LoginPresenterImple implements LoginPresenter {


    private final LoginFragmentViewCallback loginFragmentViewCallback;
    private final LoginModel loginModel;

    public LoginPresenterImple(LoginFragmentViewCallback loginFragmentViewCallback) {
        this.loginFragmentViewCallback = loginFragmentViewCallback;
        loginModel = new LoginImple();
    }

    @Override
    public void doLogin(String userId, String password) {
        loginFragmentViewCallback.showProgress();

        boolean result = loginModel.validate(userId, password);

        if (result) {
            loginFragmentViewCallback.onLoginSuccess();
        } else {
            loginFragmentViewCallback.onLoginFailed();
        }

        loginFragmentViewCallback.endProgress();

    }
}
