package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.BinarySearch2006;
import com.moon.binarySearch.LinearSearch;
import com.moon.binarySearch.Search;
import org.jcheck.annotations.Generator;
import org.jcheck.annotations.UseGenerators;
import org.jcheck.generator.primitive.ArrayGen;
import org.jcheck.generator.primitive.ByteGen;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author John Doe The Programmer
 */
@RunWith(org.jcheck.runners.JCheckRunner.class)
public class JCheckTest {
    private final Search binarySearch = new BinarySearch2006();
    private final Search linearSearch = new LinearSearch();

    @Test
    public void binarySearch(byte[] haystack, byte needle) {
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
