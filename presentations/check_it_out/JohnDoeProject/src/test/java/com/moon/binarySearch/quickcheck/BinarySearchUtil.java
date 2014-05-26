package com.moon.binarySearch.quickcheck;

import org.junit.Assert;

import java.util.Arrays;

/**
 * Check search element in array.
 *
 * @author John Doe The Programmer
 * @version 1.0
 * @since June 2000
 */
public class BinarySearchUtil {
    public static void assertSearch(byte[] haystack, byte needle, int index) {
        String msg = Arrays.toString(haystack) + " actual index of " + needle + " = " + index;
        if (index < 0) {
            for (byte b : haystack)
                Assert.assertNotEquals(msg, needle, b);
            return;
        }
        Assert.assertEquals(msg, needle, haystack[index]);
        if (index > 0)
            Assert.assertTrue(msg, haystack[index - 1] < needle);
    }
}
