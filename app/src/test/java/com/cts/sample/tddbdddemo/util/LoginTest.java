package com.cts.sample.tddbdddemo.util;

import com.cts.sample.tddbdddemo.login_mvp.LoginImple;
import com.cts.sample.tddbdddemo.login_mvp.LoginModel;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by shanmg02 on 12/09/2015.
 */
public class LoginTest {


    @Test
    public void thatPassValidEmailIdAndReturnsTrue() {
        //Third : Do the setup for the testcase
        LoginModel loginImple = new LoginImple();

        // Second : we have to define the expected result & do the action for the result.
        // Now it shows an error in the action
        boolean expectedResult = true;
        boolean result = loginImple.validate("ganesh@gmail.com", "mypassword");

        //First : we have to write the assert condition, it shows an error it does not have the result
        // & expected Result doesnot have
        assertThat(result, is(expectedResult));
    }


    @Test
    public void thatPassInValidEmailIdAndReturnsFalse() {
        //Third : Do the setup for the testcase
        LoginModel loginImple = new LoginImple();

        // Second : we have to define the expected result & do the action for the result.
        // Now it shows an error in the action.

        boolean expectedResult = false;
        boolean result = loginImple.validate("ganesh", "mypassword");

        //First : we have to write the assert condition, it shows an error it does not have the result
        // & expected Result doesnot have
        assertThat(result, is(expectedResult));

        // Handling Multiple assertion: We can all business condition for the invalidate credentials.
        // No need to write the multiple testcast

        //Action 1: send the empty credentials
        result = loginImple.validate("", "");
        assertThat(result, is(expectedResult));

        //Action 2: Send the empty password
        result = loginImple.validate("ganesh@gmail.com", "");
        assertThat(result, is(expectedResult));


        //Action 3: Send valid email & invalid password
        result = loginImple.validate("ganesh@gmail.com", "pass");
        assertThat(result, is(expectedResult));

        //Action 4: send invalid email & valid password
        result = loginImple.validate("ganesh@gmail", "password");
        assertThat(result, is(expectedResult));

    }

}
