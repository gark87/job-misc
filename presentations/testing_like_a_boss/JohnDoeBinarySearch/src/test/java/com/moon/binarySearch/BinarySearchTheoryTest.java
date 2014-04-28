package com.moon.binarySearch;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author John Doe
 * @version 2.0
 * @since May 2001
 */
@RunWith(Theories.class)
public class BinarySearchTheoryTest {
    private final BinarySearch binarySearch = new BinarySearch2007();

    @Theory
    public void binarySearch(@ForAll byte[] haystack, @ForAll byte needle) {
        Arrays.sort(haystack);
        String msg = Arrays.toString(haystack) + " with " + needle;

        System.out.println(msg);
        int actual = binarySearch.execute(haystack, needle);

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
