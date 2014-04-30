package com.moon.binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * Like {@link BinarySearch2007Test}, but with "integer overflow" test.
 * @author John Doe
 * @version 5.0
 * @since December 2009
 */
public class BinarySearch2009Test {
    private final BinarySearch binarySearch = new BinarySearch2007();

    @Test
    public void hugeArrayTest() {
        int actual = binarySearch.execute(new byte[1100000000], (byte) 1);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void sameTest() {
        byte[] haystack = new byte[]{1, 1, 1, 1};
        byte needle = 1;
        int actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(0, actual);
    }

    @Test
    public void missingTest() {
        byte[] haystack = new byte[]{1, 2, 3, 4};
        byte needle = 5;
        int actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(-1, actual);
        needle = 0;
        actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void simpleTest() {
        byte[] haystack = new byte[]{1, 2, 3, 4};
        byte needle = 4;
        int actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(3, actual);
        needle = 1;
        actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(0, actual);
    }
}