package com.moon.binarySearch.quickcheck;

import com.moon.binarySearch.BinarySearch2006;
import com.moon.binarySearch.Search;
import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.CombinedGenerators;
import net.java.quickcheck.generator.PrimitiveGenerators;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Like {@link QuickcheckTest}, but using {@link Theories}
 * @author John Doe The Programmer
 */
@RunWith(Theories.class)
public class TheoryTest {
    private final Search binarySearch = new BinarySearch2006();

    @DataPoints
    public static final byte[][] haystacks =
            toArray(CombinedGenerators.byteArrays(), 100, byte[].class);

    @DataPoints
    public static final Byte[] needles =
            toArray(PrimitiveGenerators.bytes(), 100, Byte.class);

    @Theory
    public void testTrie(byte[] haystack, Byte needle) {
        Arrays.sort(haystack);

        String msg = Arrays.toString(haystack) + " with " + needle;

        int actual;
        try {
            actual = binarySearch.execute(haystack, needle);
        } catch (Throwable t) {
            throw new IllegalStateException(msg, t);
        }

        BinarySearchUtil.assertSearch(haystack, needle, actual);
    }

    private static <T> T[] toArray(Generator<T> gen, int length, Class<T> clazz) {
        T[] result = (T[]) Array.newInstance(clazz, length);
        for (int i = 0; i < length; i++)
            result[i] = gen.next();
        return result;
    }
}
