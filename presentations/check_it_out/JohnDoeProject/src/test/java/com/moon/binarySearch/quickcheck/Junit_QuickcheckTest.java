package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.BinarySearch2006;
import com.moon.binarySearch.Search;
import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.*;

import static com.moon.binarySearch.quickcheck.BinarySearchUtil.assertSearch;

/**
 * Using junit-quickcheck
 *
 * @author John Doe The Programmer
 */
@RunWith(Theories.class)
public class Junit_QuickcheckTest {
    private final Search binarySearch = new BinarySearch2006();

    @Theory
    public void binarySearch(@ForAll byte[] haystack, @ForAll(sampleSize=10) byte needle) {
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