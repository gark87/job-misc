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
    private final Search binarySearch = new BinarySearch2007();
    private final Search linearSearch = new LinearSearch();

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
        int expected = linearSearch.execute(haystack, needle);
        assertEquals(msg, expected, actual);
    }
}