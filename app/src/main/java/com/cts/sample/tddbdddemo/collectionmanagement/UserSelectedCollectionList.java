package com.cts.sample.tddbdddemo.collectionmanagement;

import java.util.List;

/**
 * Created by 268526 on 11/25/2015.
 */
public interface UserSelectedCollectionList {


    List<CollectionModel> fetchUserSelectedCollection(String username);
}
