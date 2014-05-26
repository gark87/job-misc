package com.moon.dna;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.distribution.Distribution;
import net.java.quickcheck.generator.support.FixedValuesGenerator;
import net.java.quickcheck.generator.support.IntegerGenerator;
import net.java.quickcheck.generator.support.StringGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * @author John Doe The Programmer
 */
public class QuickcheckTest {
    @Test
    public void testTrie() {
        Generator<String> dnaGen = new StringGenerator(new IntegerGenerator(1, 100, Distribution.POSITIV_NORMAL),
                new FixedValuesGenerator<>(Arrays.asList('A', 'T', 'C', 'G')));
        Generator<Trie> trieGen = new TrieGenerator(dnaGen);
        for (int i = 0; i < 10000; i++) {
            Trie trie = trieGen.next();
            String newValue = dnaGen.next();

            Set<String> expected = trie.getAllStrings();
            expected.add(newValue);
            trie.add(newValue);
            Set<String> actual = trie.getAllStrings();

            Assert.assertEquals("Iteration: " + i, expected, actual);
        }
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
}
