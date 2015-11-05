package com.cts.sample.tddbdddemo.login;

/**
 * Created by shanmg02 on 01/10/2015.
 */
public class CoverageExcludeSample implements ExcludeCodeCoverage {

    public void sample() {

        int i = 0;
        for (int x = 0; x < 10; x++) {
            i = x;
        }

        System.out.println(i);

    }
}
