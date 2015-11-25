package com.cts.sample.tddbdddemo.util;

import com.cts.sample.tddbdddemo.collectionmanagement.UserSelectedCollectionListImpl;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by 268526 on 11/25/2015.
 */
public class UserSelectedCollectionListImplTest {

    @Test
    public void thatPassesValidUsernameAndReturnsCollectionList() {
        UserSelectedCollectionListImpl impl = new UserSelectedCollectionListImpl();

        // Action 1: Set a valid user
        String username = "testUser";
        assertNotNull(impl.fetchUserSelectedCollection(username));

        // Action 2: Set an empty user
        username = "";
        assertNull(impl.fetchUserSelectedCollection(username));

        //Action 3: Set an invalid user
        username = "anotherUser";
        assertNull(impl.fetchUserSelectedCollection(username));
    }
}
