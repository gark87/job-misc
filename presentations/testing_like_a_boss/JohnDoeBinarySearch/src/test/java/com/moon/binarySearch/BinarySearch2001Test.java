package com.moon.binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * First unit test, check simple case.
 *
 * @author John Doe
 * @version 2.0
 * @since May 2001
 */
public class BinarySearch2001Test {
    private final Search binarySearch = new BinarySearch2001();

    @Test
    public void simpleTest() {
        byte[] haystack = new byte[]{1,2,3,4};
        byte needle = 4;
        int actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(3, actual);
        needle = 1;
        actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(0, actual);
    }
}
