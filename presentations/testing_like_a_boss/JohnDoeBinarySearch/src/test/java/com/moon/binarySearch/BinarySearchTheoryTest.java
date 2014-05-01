package com.moon.binarySearch;

import org.junit.contrib.theories.DataPoints;
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
public class BinarySearchTheoryTest {
    private static final byte[][] HAYSTACKS = {{1, 1, 1, 1}, {1, 2, 3, 4}};
    private static final byte[] NEEDLES = {0, 1, 4, 5};
    private final BinarySearch binarySearch = new BinarySearch2006();

    @DataPoints
    public static TestData[] haystackData() {
        List<TestData> result = new ArrayList<>();
        for (byte[] haystack : HAYSTACKS) {
            for (byte needle : NEEDLES)
                result.add(new TestData(needle, haystack));
        }
        return result.toArray(new TestData[result.size()]);
    }

    @Theory
    public void testBinarySearch(TestData data) {
        byte[] haystack = data.haystack;
        byte needle = data.needle;

        int actual;
        try {
            actual = binarySearch.execute(haystack, needle);
        } catch (Throwable t) {
            throw new IllegalStateException(data.toString(), t);
        }

        // check binary search with linear search
        int expected = -1;
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == needle) {
                expected = i;
                break;
            }
        }
        assertEquals(data.toString(), expected, actual);
    }

    private static class TestData {
        private final byte needle;
        private final byte[] haystack;

        private TestData(byte needle, byte... haystack) {
            this.needle = needle;
            this.haystack = haystack;
            Arrays.sort(haystack);
        }

        @Override
        public String toString() {
            return Arrays.toString(haystack) + " with " + needle;
        }
    }
}