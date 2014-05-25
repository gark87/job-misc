package com.moon.dna;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.junit.Assert;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Set;

/**
 * @author John Doe The Programmer
 */
@RunWith(Theories.class)
public class JUnit_quickcheckTest {
    @Theory
    public void testTrie(@ForAll @From(TrieGenerator.class) Trie trie,
                         @ForAll @From(DNAGenerator.class) String newValue)
    {
        Set<String> expected = trie.getAllStrings();
        expected.add(newValue);
        trie.add(newValue);
        Set<String> actual = trie.getAllStrings();

        Assert.assertEquals(expected, actual);
    }

    public static class DNAGenerator extends Generator<String> {
        private static final char[] CHARS = {'A', 'T', 'G', 'C'};

        public DNAGenerator() {
            super(String.class);
        }

        @Override
        public String generate(SourceOfRandomness random, GenerationStatus status) {
            int length = random.nextInt(1, Math.max(1, status.size()));
            char[] chars = new char[length];
            for (int i = 0; i < length; i++)
                chars[i] = CHARS[random.nextInt(CHARS.length)];
            return new String(chars);
        }
    }

    public static class TrieGenerator extends Generator<Trie> {
        private final Generator<String> stringGenerator = new DNAGenerator();

        public TrieGenerator() {
            super(Trie.class);
        }

        @Override
        public Trie generate(SourceOfRandomness random, GenerationStatus status) {
            int length = 1 + random.nextInt(Math.max(1, status.size()));

            Trie result = new Trie();
            for (int i = 0; i < length; i++)
                result.add(stringGenerator.generate(random, status));
            return result;
        }
    }
}
