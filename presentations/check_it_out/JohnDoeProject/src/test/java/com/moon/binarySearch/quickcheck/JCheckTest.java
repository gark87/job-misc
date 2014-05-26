package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.BinarySearch2006;
import com.moon.binarySearch.Search;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static com.moon.binarySearch.quickcheck.BinarySearchUtil.assertSearch;

/**
 * @author John Doe The Programmer
 */
@RunWith(org.jcheck.runners.JCheckRunner.class)
public class JCheckTest {
    private final Search binarySearch = new BinarySearch2006();

    @Test
    public void binarySearch(byte[] haystack, byte needle) {
        Arrays.sort(haystack);

        int actual;
        try {
            actual = binarySearch.execute(haystack, needle);
        } catch (Throwable t) {
            throw new IllegalStateException(Arrays.toString(haystack) + " with " + needle, t);
        }

        assertSearch(haystack, needle, actual);
    }
}
