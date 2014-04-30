package com.moon.binarySearch;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * QuickCheck-style test.
 *
 * @author John Doe
 * @version 2.0
 * @since May 2001
 */
@RunWith(Theories.class)
public class BinarySearchTheoryTest {
    private final BinarySearch binarySearch = new BinarySearch2006();

    @Theory
    public void binarySearch(@ForAll byte[] haystack, @ForAll byte needle) {
        Arrays.sort(haystack);
        String msg = Arrays.toString(haystack) + " with " + needle;

        int actual;
        try {
            actual = binarySearch.execute(haystack, needle);
        } catch (Throwable t) {
            throw new IllegalStateException(msg, t);
        }

        // check binary search with linear search
        int expected = -1;
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                expected = i;
                break;
            }
        }
        assertEquals(msg, expected, actual);
    }
}