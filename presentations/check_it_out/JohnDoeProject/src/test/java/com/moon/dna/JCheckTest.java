package com.moon.dna;

import org.jcheck.Arbitrary;
import org.jcheck.annotations.*;
import org.jcheck.generator.Gen;
import org.jcheck.runners.JCheckRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Trie}
 *
 * @author John Doe The Programmer
 */
@RunWith(JCheckRunner.class)
public class JCheckTest {
    @Test
    @UseGenerators({
            @Generator(klass = String.class, generator = StringGenerator.class),
            @Generator(klass = Trie.class, generator = TrieGenerator.class)
    })
    public void testTrieWithStrings(Trie trie, String extra) {
        Set<String> expected = trie.getAllStrings();
        expected.add(extra);

        trie.add(extra);

        Set<String> actual = trie.getAllStrings();
        assertEquals(expected, actual);
    }

    public static class StringGenerator implements Gen<String> {
        private static final char[] CHARS = {'A', 'T', 'G', 'C'};

        @Override
        public String arbitrary(Random random, long size) {
            int length = 1 + (int) Arbitrary.random(random, 0, size - 1);
            char[] chars = new char[length];
            for (int i = 0; i < length; i++)
                chars[i] = CHARS[random.nextInt(CHARS.length)];
            return new String(chars);
        }
    }

    public static class TrieGenerator implements Gen<Trie> {
        private final static StringGenerator gen = new StringGenerator();

        @Override
        public Trie arbitrary(Random random, long size) {
            Trie result = new Trie();
            int length = (int) Arbitrary.random(random, 0, size - 1);
            for (int i = 0; i < length; i++)
                result.add(gen.arbitrary(random, size));
            return result;
        }
    }
}
