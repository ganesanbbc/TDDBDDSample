package com.cts.sample.tddbdddemo.test;

import android.test.ActivityInstrumentationTestCase2;

import com.cts.sample.tddbdddemo.introscreen.WelcomeScreenActivity;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;

/**
 * Created by shanmg02 on 12/09/2015.
 */
@CucumberOptions(features = "features")
public class WelcomeScreenActivitySteps extends ActivityInstrumentationTestCase2<WelcomeScreenActivity> {


    public WelcomeScreenActivitySteps(SomeDependency someDependency) {
        super(WelcomeScreenActivity.class);
        assertNotNull(someDependency);
    }

    @Given("^I have a WelcomeScreenActivity")
    public void I_have_a_WelcomeScreenActivity$() {
        assertNotNull(getActivity());
    }

}
