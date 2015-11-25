package com.cts.sample.tddbdddemo.util;

import com.cts.sample.tddbdddemo.collectionmanagement.CollectionModel;
import com.cts.sample.tddbdddemo.collectionmanagement.ReorderCollectionList;
import com.cts.sample.tddbdddemo.collectionmanagement.ReorderCollectionListImpl;

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by 460790 on 11/25/2015.
 */
public class ReorderCollectionListImplTest {
    @Test
    public void thatReorderSelectedCollectionListAndReturnsCollectionList() {

        ReorderCollectionList nCList = new ReorderCollectionListImpl();
        List<CollectionModel> expectedResult = nCList.reorderList();
        assertNotNull(expectedResult);
    }
}
