package com.cts.sample.tddbdddemo.util;

import android.util.Log;

import com.cts.sample.tddbdddemo.collectionmanagement.CollectionModel;
import com.cts.sample.tddbdddemo.collectionmanagement.ReorderCollectionList;
import com.cts.sample.tddbdddemo.collectionmanagement.ReorderCollectionListImpl;
import com.cts.sample.tddbdddemo.collectionmanagement.UserSelectedCollectionList;
import com.cts.sample.tddbdddemo.collectionmanagement.UserSelectedCollectionListImpl;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by 460790 on 11/25/2015.
 */
public class ReorderCollectionListImplTest {
    @Test
    public void thatReordersSelectedCollectionListAndReturnsCollectionList() {

        ReorderCollectionList nCList = new ReorderCollectionListImpl();
        UserSelectedCollectionList uCList = new UserSelectedCollectionListImpl();

        String username = "testUser";
        List<CollectionModel> oldCollectionList = uCList.fetchUserSelectedCollection(username);

        // Action: User reorders list
        int oldIndex = 0;
        int newIndex = 2;
        List<CollectionModel> newCollectionList = nCList.reorderList(oldCollectionList, oldIndex, newIndex);
        Assert.assertNotSame("Not equals", oldCollectionList.get(oldIndex).getId(), newCollectionList.get(newIndex).getId());
    }
}
