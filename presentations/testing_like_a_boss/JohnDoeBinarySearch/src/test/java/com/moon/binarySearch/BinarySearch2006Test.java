package com.moon.binarySearch;

import org.junit.Assert;
import org.junit.Test;

/**
 * Like {@link BinarySearch2001Test}, but with "missing item" test.
 *
 * @author John Doe
 * @version 3.0
 * @since July 2006
 */
public class BinarySearch2006Test {
    private final BinarySearch binarySearch = new BinarySearch2006();

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
