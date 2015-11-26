package com.cts.sample.tddbdddemo.collectionmanagement;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by 460790 on 11/25/2015.
 */
public class ReorderCollectionListImpl implements ReorderCollectionList {
    //    private final static String TAG = ReorderCollectionListImpl.class.getSimpleName();
    private List<CollectionModel> uCList;

    @Override
    public List<CollectionModel> reorderList(List<CollectionModel> oldCollectionList, int oldIndex, int newIndex) throws IndexOutOfBoundsException {
        uCList = new ArrayList<>(oldCollectionList);
//        Collections.copy(uCList, oldCollectionList);

        System.out.println("Original List:");
        System.out.println(oldCollectionList);
        CollectionModel dataOfOldIndex = oldCollectionList.get(oldIndex);
        CollectionModel dataOfNewIndex = oldCollectionList.get(newIndex);

        uCList.set(newIndex, dataOfOldIndex);
        uCList.set(oldIndex, dataOfNewIndex);

        System.out.println("Reordered List:");
        System.out.println(uCList);

        return uCList;
    }
}
