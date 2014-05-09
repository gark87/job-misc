package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.BinarySearch2007;
import com.moon.binarySearch.Search;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Like {@link com.moon.binarySearch.BinarySearch2009Test}, but using {@link org.junit.runners.Parameterized}
 *
 * @author John Doe The Programmer
 */
@RunWith(Parameterized.class)
public class ParameterizedTest {
    private final Search binarySearch = new BinarySearch2007();
    private final byte[] haystack;
    private final byte needle;
    private final int expected;

    public ParameterizedTest(byte[] haystack, byte needle, int expected) {
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
