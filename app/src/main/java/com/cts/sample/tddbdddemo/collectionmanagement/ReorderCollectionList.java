package com.cts.sample.tddbdddemo.collectionmanagement;

import java.util.List;

/**
 * Created by 460790 on 11/25/2015.
 */
public interface ReorderCollectionList {
    List<CollectionModel> reorderList(List<CollectionModel> oldCollectionList, int oldIndex, int newIndex);
}
