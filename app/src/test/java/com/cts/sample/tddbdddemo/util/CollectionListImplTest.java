package com.cts.sample.tddbdddemo.util;

import com.cts.sample.tddbdddemo.collectionmanagement.CollectionList;
import com.cts.sample.tddbdddemo.collectionmanagement.CollectionListImpl;
import com.cts.sample.tddbdddemo.collectionmanagement.CollectionModel;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by 268526 on 11/23/2015.
 */
public class CollectionListImplTest {

    @Test
    public void thatFetchesCollectionListAndReturnsCollectionList() {
        CollectionList cList = new CollectionListImpl();

//        List<CollectionModel> result = new ArrayList<>();
        List<CollectionModel> expectedResult = cList.fetchCollectionList();

        assertNotNull(expectedResult);

    }
}
