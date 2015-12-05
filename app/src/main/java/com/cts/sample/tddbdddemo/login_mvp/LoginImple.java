package com.cts.sample.tddbdddemo.login_mvp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shanmg02 on 11/09/2015.
 */
public class LoginImple implements LoginModel {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final int PASSWORD_MIN_LENGTH = 8;

    private Pattern pattern;
    private Matcher matcher;
    public LoginImple() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean validate(String email, String password) {
        return validateEmail(email) && validatePassword(password);
    }

    private boolean validateEmail(String userId) {
        matcher = pattern.matcher(userId);
        return matcher.matches();
    }

    private boolean validatePassword(String password) {
        return password.length() >= PASSWORD_MIN_LENGTH;
    }
}
