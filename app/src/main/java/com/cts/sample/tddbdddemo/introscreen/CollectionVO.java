package com.cts.sample.tddbdddemo.introscreen;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by shanmg02 on 04/12/15.
 */
public class CollectionVO {


    @SerializedName("type")
    public String type;

    @SerializedName("title")
    public String title;

    @SerializedName("status")
    public String status="";

    @SerializedName("model")
    public ArrayList<Model> model;

    @Override
    public String toString() {
        return title+"::"+model;
    }


}
