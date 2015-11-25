package com.cts.sample.tddbdddemo.collectionmanagement;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 268526 on 11/23/2015.
 */

public class CollectionModel {

    @SerializedName("max_id")
    private int id;

    public CollectionModel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
