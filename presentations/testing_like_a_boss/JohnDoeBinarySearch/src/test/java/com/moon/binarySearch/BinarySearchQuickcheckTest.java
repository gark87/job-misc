package com.moon.binarySearch;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Like {@link BinarySearchParameterizedTest}, but using {@link Theories}.
 *
 * @author John Doe
 */
@RunWith(Theories.class)
public class BinarySearchQuickcheckTest {
    private final BinarySearch binarySearch = new BinarySearch2006();

    @Theory
    public void binarySearch(@ForAll byte[] haystack, @ForAll(sampleSize=10) byte needle) {
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