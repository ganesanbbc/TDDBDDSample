package com.cts.sample.tddbdddemo.collectionmanagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 268526 on 11/25/2015.
 */
public class UserSelectedCollectionListImpl implements UserSelectedCollectionList {
    private List<CollectionModel> uCList;


    @Override
    public List<CollectionModel> fetchUserSelectedCollection(String username) {
        if (!isEmpty(username) && username.equals("testUser")) {
            populateSampleData();
            return uCList;
        }
        return null;
    }

    private boolean isEmpty(String username) {
        return (username == null || username.equalsIgnoreCase(""));
    }

    private void populateSampleData() {
        uCList = new ArrayList<>();
        uCList.add(new CollectionModel(0));
        uCList.add(new CollectionModel(1));
        uCList.add(new CollectionModel(2));
        uCList.add(new CollectionModel(3));
    }
}
