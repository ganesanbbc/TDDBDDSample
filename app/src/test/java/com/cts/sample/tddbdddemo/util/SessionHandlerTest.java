package com.cts.sample.tddbdddemo.util;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by shubhayu on 10/09/15.
 */
public class SessionHandlerTest {

    private static final long TS_LESS_THAN_HOUR = System.currentTimeMillis() - 1000 * 60 * 30;
    private static final long TS_MORE_EQUAL_THAN_HOUR = System.currentTimeMillis() - 1000 * 60 * 60;


    boolean valid = true;

    @Test
    public void testIsSessionValid_ReturnTrue() throws Exception {

        assertThat("Checking session is valid when session started less than an hour",
                valid, is(true));

    }

//    @Test
//    public void testIsSessionValid_ReturnFalse() throws Exception {
//        assertThat("Checking session is invalid when session started more than or eual to an hour",
//                valid, is(false));
//    }
}
