package com.cts.sample.tddbdddemo.introscreen;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shanmg02 on 04/12/15.
 */
class Model {

    @SerializedName("title")
    public String title;

    @SerializedName("url")
    public String url;


    @Override
    public String toString() {
        return  title;
    }
}
