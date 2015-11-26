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

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof CollectionModel) {
            return ((CollectionModel) o).getId() == id;
        }
        return super.equals(o);
    }
}
