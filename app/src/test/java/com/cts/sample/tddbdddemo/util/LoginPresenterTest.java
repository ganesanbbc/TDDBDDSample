package com.cts.sample.tddbdddemo.util;

import com.cts.sample.tddbdddemo.login.LoginPresenter;
import com.cts.sample.tddbdddemo.login.LoginFragmentViewCallback;
import com.cts.sample.tddbdddemo.login.LoginPresenterImple;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/**
 * Created by shanmg02 on 12/09/2015.
 */
public class LoginPresenterTest {

    @Test
    public void thatPassInvalidCredentialAndLoginFailedCalled() {
        FakeCallback loginPresenterCallback = new FakeCallback();
        LoginPresenter loginPresenter = new LoginPresenterImple(loginPresenterCallback);

        loginPresenter.doLogin("", "");

        assertTrue(loginPresenterCallback.failedCalled);
    }

    @Test
    public void thatPassValidCredentialAndLoginSuccessCalled() {
        FakeCallback loginPresenterCallback = new FakeCallback();
        LoginPresenter loginPresenter = new LoginPresenterImple(loginPresenterCallback);

        loginPresenter.doLogin("s@d.com", "12345678");

        assertTrue(loginPresenterCallback.successCalled);
    }


    private class FakeCallback implements LoginFragmentViewCallback {

        public boolean failedCalled;
        public boolean successCalled;


        @Override
        public void showProgress() {

        }

        @Override
        public void endProgress() {

        }

        @Override
        public void onLoginSuccess() {
            successCalled = true;
        }

        @Override
        public void onLoginFailed() {
            failedCalled = true;
        }
    }
}
