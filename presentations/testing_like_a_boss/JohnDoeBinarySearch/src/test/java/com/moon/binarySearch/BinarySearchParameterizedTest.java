package com.moon.binarySearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Like {@link BinarySearch2009Test}, but using {@link org.junit.runners.Parameterized}
 *
 * @author John Doe
 */
@RunWith(Parameterized.class)
public class BinarySearchParameterizedTest {
    private final Search binarySearch = new BinarySearch2007();
    private final byte[] haystack;
    private final byte needle;
    private final int expected;

    public BinarySearchParameterizedTest(byte[] haystack, byte needle, int expected) {
        this.haystack = haystack;
        this.needle = needle;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        byte[] array = {1, 2, 3, 4};
        byte[] sameArray = {1, 1, 1, 1};
        return Arrays.asList(new Object[][]{
                {sameArray, (byte) 1, 0},
                {array, (byte) 5, -1},
                {array, (byte) 0, -1},
                {array, (byte) 4, 3},
                {array, (byte) 1, 0},
        });
    }

    @Test
    public void test() {
        int actual = binarySearch.execute(haystack, needle);
        Assert.assertEquals(expected, actual);
    }
}
