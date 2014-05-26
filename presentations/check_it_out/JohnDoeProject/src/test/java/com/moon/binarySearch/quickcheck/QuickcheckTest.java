package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.*;
import net.java.quickcheck.Generator;
import org.junit.Test;

import java.util.*;

import static com.moon.binarySearch.quickcheck.BinarySearchUtil.assertSearch;
import static net.java.quickcheck.generator.CombinedGenerators.byteArrays;
import static net.java.quickcheck.generator.PrimitiveGenerators.*;

/**
 * Using quickcheck
 *
 * @author John Doe The Programmer
 */
public class QuickcheckTest {
    private final Search binarySearch = new BinarySearch2006();

    @Test
    public void testBinarySearch() {
        Generator<byte[]> byteArrays = byteArrays();
        Generator<Byte> bytes = bytes();

        for (int i = 0; i < 10000; i++) {
            byte[] haystack = byteArrays.next();
            Arrays.sort(haystack);
            Byte needle = bytes.next();

            int actual;
            try {
                actual = binarySearch.execute(haystack, needle);
            } catch (Throwable t) {
                throw new IllegalStateException(Arrays.toString(haystack) + " with " + needle, t);
            }

            assertSearch(haystack, needle, actual);
        }
    }
}