package com.cts.sample.tddbdddemo.collectionmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 268526 on 11/25/2015.
 */
public class UserSelectedCollectionListImpl implements UserSelectedCollectionList {
    @Override
    public List<CollectionModel> fetchUserSelectedCollection(String username) {
        if(!isEmpty(username) && username.equals("testUser")) {
            return new ArrayList<>();
        }
        return null;
    }

    private boolean isEmpty(String username) {
        return (username == null || username.equalsIgnoreCase(""));
    }
}
