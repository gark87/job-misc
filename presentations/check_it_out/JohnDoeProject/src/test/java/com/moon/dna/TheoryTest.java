package com.moon.dna;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.distribution.Distribution;
import net.java.quickcheck.generator.support.IntegerGenerator;
import net.java.quickcheck.generator.support.StringGenerator;
import org.junit.Assert;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.lang.reflect.Array;
import java.util.Set;

/**
 * @author John Doe The Programmer
 */
@RunWith(Theories.class)
public class TheoryTest {
    private static final StringGenerator dnaGen
            = new StringGenerator(new IntegerGenerator(1, 100, Distribution.POSITIV_NORMAL), new DNAGenerator());

    @DataPoints
    public static final String[] dnas = toArray(dnaGen, 100, String.class);

    @DataPoints
    public static final Trie[] tries = toArray(new TrieGenerator(dnaGen), 10, Trie.class);

    @Theory
    public void testTrie(Trie trie, String newValue) {
        Set<String> expected = trie.getAllStrings();
        expected.add(newValue);
        trie.add(newValue);
        Set<String> actual = trie.getAllStrings();

        Assert.assertEquals(expected, actual);
    }

    private static <T> T[] toArray(Generator<T> gen, int length, Class<T> clazz) {
        T[] result = (T[]) Array.newInstance(clazz, length);
        for (int i = 0; i < length; i++)
            result[i] = gen.next();
        return result;
    }

    private static class TrieGenerator implements Generator<Trie> {
        private final Generator<Integer> lengthGen = new IntegerGenerator(1, 100, Distribution.POSITIV_NORMAL);
        private final Generator<String> dnaGen;

        public TrieGenerator(Generator<String> dnaGen) {
            this.dnaGen = dnaGen;
        }

        @Override
        public Trie next() {
            Trie result = new Trie();
            for (int i = 0; i < lengthGen.next(); i++)
                result.add(dnaGen.next());
            return result;
        }
    }

    private static class DNAGenerator implements Generator<Character> {
        private static final char[] CHARS = {'A', 'T', 'G', 'C'};
        private final IntegerGenerator generator = new IntegerGenerator(0, CHARS.length - 1);

        @Override
        public Character next() {
            return CHARS[generator.nextInt()];
        }
    }
}
