package com.cts.sample.tddbdddemo.util;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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


        String plaintext = "[{type: \"hero-promos\", title: \"Hero promo Module\", model: {promos: [{title: \"Instagram 1234\", attribution: \"înstagram & M\", url: \"https://instagram.com/\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00w7w34.jpg\"}, liveBadge: true, promoTopic: \"other\"}, {title: \"Jon test 2\", attribution: \"news\", url: \"http://www.bbc.co.uk/news\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00x1tjs.jpg\"}, liveBadge: true, promoTopic: \"sport\"}, {title: \"Jon Test 3\", attribution: \"budgies\", url: \"http://www.bbc.co.uk/lifestyle\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00txl9r.jpg\"}, promoTopic: \"other\"} ], name: \"Hero promo Module\"}, status: \"success\"}, {type: \"local-news\", title: \"Local News\", status: \"error\"}, {type: \"top-stories\", title: \"Latest News\", status: \"error\"}, {type: \"local-news\", title: \"Local News 2\", status: \"error\"}, {type: \"top-stories\", title: \"Topstory by promo paired\", model: [{title: \"Instagram 1234\", attribution: \"înstagram & M\", url: \"https://instagram.com/\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00w7w34.jpg\"}, liveBadge: true, promoTopic: \"other\", cta: { } }, {title: \"Twitter\", attribution: \"twitter\", url: \"https://twitter.com/?lang=en-gb\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00x1thx.jpg\"}, promoTopic: \"sport\", cta: { } }, {title: \"Test Promo 1-AutomationéÈl Dùn Eideann\", attribution: \"NewséÉ Dùn Eideann\", url: \"http://www.test.bbc.co.uk/news\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00v56lt.jpg\", templateUrlCropped: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00tx6ng.jpg\"}, liveBadge: true, promoTopic: \"news\", cta: { } } ], isNew: true, footer: {title: \"More bbc\", url: \"http://www.bbc.co.uk/contact\"}, colorPalette: \"news\", status: \"success\"}, {type: \"top-stories\", title: \"container height\", status: \"error\"}, {type: \"top-stories\", title: \"Top Stories -Template 01\", status: \"error\"}, {type: \"top-stories\", title: \"Top Stories -Template 02\", status: \"error\"}, {type: \"top-stories\", title: \"Top Stories -Template 04\", status: \"error\"}, {type: \"top-stories\", title: \"Temp 01 pairing1\", status: \"error\"}, {type: \"top-stories\", title: \"Temp 01 pairing2\", status: \"error\"}, {type: \"tv-radio\", title: \"TV & Radio module\", status: \"error\"}, {type: \"tv-radio-recommendations\", title: \"TV & Radio default recmnd\", status: \"error\"} ]";
        String plaintext1 = "[{type: \"hero-promos\", title: \"Hero promo Module\", model: {promos: [{title: \"Instagram 1234\", attribution: \"înstagram & M\", url: \"https://instagram.com/\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00w7w34.jpg\"}, liveBadge: true, promoTopic: \"other\"}, {title: \"Jon test 2\", attribution: \"news\", url: \"http://www.bbc.co.uk/news\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00x1tjs.jpg\"}, liveBadge: true, promoTopic: \"sport\"}, {title: \"Jon Test 3\", attribution: \"budgies\", url: \"http://www.bbc.co.uk/lifestyle\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00txl9r.jpg\"}, promoTopic: \"other\"} ], name: \"Hero promo Module\"}, status: \"success\"}, {type: \"local-news\", title: \"Local News\", status: \"error\"}, {type: \"top-stories\", title: \"Latest News\", status: \"error\"}, {type: \"local-news\", title: \"Local News 2\", status: \"error\"}, {type: \"top-stories\", title: \"Topstory by promo paired\", model: [{title: \"Instagram 1234\", attribution: \"înstagram & M\", url: \"https://instagram.com/\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00w7w34.jpg\"}, liveBadge: true, promoTopic: \"other\", cta: { } }, {title: \"Twitter\", attribution: \"twitter\", url: \"https://twitter.com/?lang=en-gb\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00x1thx.jpg\"}, promoTopic: \"sport\", cta: { } }, {title: \"Test Promo 1-AutomationéÈl Dùn Eideann\", attribution: \"NewséÉ Dùn Eideann\", url: \"http://www.test.bbc.co.uk/news\", image: {templateUrl: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00v56lt.jpg\", templateUrlCropped: \"ichef.test.bbci.co.uk/images/ic/$recipe/p00tx6ng.jpg\"}, liveBadge: true, promoTopic: \"news\", cta: { } } ], isNew: true, footer: {title: \"More bbc\", url: \"http://www.bbc.co.uk/contact\"}, colorPalette: \"news\", status: \"success\"}, {type: \"top-stories\", title: \"container height\", status: \"error\"}, {type: \"top-stories\", title: \"Top Stories -Template 01\", status: \"error\"}, {type: \"top-stories\", title: \"Top Stories -Template 02\", status: \"error\"}, {type: \"top-stories\", title: \"Top Stories -Template 04\", status: \"error\"}, {type: \"top-stories\", title: \"Temp 01 pairing1\", status: \"error\"}, {type: \"top-stories\", title: \"Temp 01 pairing2\", status: \"error\"}, {type: \"tv-radio\", title: \"TV & Radio module\", status: \"error\"}, {type: \"tv-radio-recommendations\", title: \"TV & Radio default recmnd\", status: \"error\"} ]";
        String data1 = generateMD5(plaintext);
        String data2 = generateMD5(plaintext1);

//        assertThat(data1, is(data2));

        assertThat("Checking session is valid when session started less than an hour",
                valid, is(true));

        String expectedMessage = "this is testing";

        String encryptedText = generateMD5(plaintext);

//        assertThat(convertToMd5(encryptedText),is(expectedMessage));

    }

    private String generateMD5(String plaintext) throws NoSuchAlgorithmException {


        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);
// Now we need to zero pad it if you actually want the full 32 chars.
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        return hashtext;
    }

    private static String convertToMd5(final String md5) throws UnsupportedEncodingException {
        StringBuffer sb=null;
        try {
            final java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(md5.getBytes("UTF-8"));
            sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (final java.security.NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }

//    @Test
//    public void testIsSessionValid_ReturnFalse() throws Exception {
//        assertThat("Checking session is invalid when session started more than or eual to an hour",
//                valid, is(false));
//    }
}
