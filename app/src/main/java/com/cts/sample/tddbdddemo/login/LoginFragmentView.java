package com.cts.sample.tddbdddemo.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.cts.sample.tddbdddemo.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragmentView extends Fragment implements LoginFragmentViewCallback {

    private OnLoginListener onLoginFragmentListener;
    private ProgressDialog progressDialog;
    private Context context;
    private final LoginPresenter loginPresenter;

    EditText userNameView;

    EditText passwordView;

    public LoginFragmentView() {
        loginPresenter = new LoginPresenterImple(this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

    }


    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        try {
            onLoginFragmentListener = (OnLoginListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnLoginListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_login, container, false);
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Logging in...");

        return view;
    }

    public void onLoginButtonClick() {
        String username = userNameView.getText().toString();
        String password = passwordView.getText().toString();

        loginPresenter.doLogin(username, password);
    }


    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void endProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void onLoginSuccess() {
        onLoginFragmentListener.onLoggedIn();
    }

    @Override
    public void onLoginFailed() {
        onLoginFragmentListener.onLogInFailed();
    }

    public interface OnLoginListener {
        void onLoggedIn();

        void onLogInFailed();
    }
}
