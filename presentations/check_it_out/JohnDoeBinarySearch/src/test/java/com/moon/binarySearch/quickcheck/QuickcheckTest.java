package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.*;
import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.CombinedGenerators;
import net.java.quickcheck.generator.PrimitiveGenerators;
import net.java.quickcheck.generator.support.ByteGenerator;
import net.java.quickcheck.generator.support.DoubleGenerator;
import net.java.quickcheck.generator.support.IntegerGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.contrib.theories.DataPoints;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.*;

import static net.java.quickcheck.generator.CombinedGenerators.arrays;
import static net.java.quickcheck.generator.CombinedGenerators.byteArrays;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someByteArrays;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someSets;
import static net.java.quickcheck.generator.PrimitiveGenerators.*;
import static org.junit.Assert.assertEquals;

/**
 * Like {@link ParameterizedTest}, but using {@link Theories}.
 *
 * @author John Doe The Programmer
 */
public class QuickcheckTest {
    private final Search binarySearch = new BinarySearch2006();
    private final Search linearSearch = new LinearSearch();

    @Test
    public void testBinarySearch() {
        Generator<byte[]> byteArrays = byteArrays();
        Generator<Byte> bytes = bytes();

        for (int i = 0; i < 10000; i++) {
            byte[] haystack = byteArrays.next();
            Arrays.sort(haystack);
            Byte needle = bytes.next();

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
}