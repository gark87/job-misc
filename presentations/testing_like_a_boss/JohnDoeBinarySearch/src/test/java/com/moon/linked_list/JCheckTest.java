package com.moon.linked_list;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.generator.ComponentizedGenerator;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import org.jcheck.generator.Gen;
import org.jcheck.generator.primitive.IntegerGen;
import org.junit.Test;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Random;

/**
 * Test for {@link SinglyLinkedListUtil}
 *
 * @author John Doe The Programmer
 */
@RunWith(org.jcheck.runners.JCheckRunner.class)
public class JCheckTest {
    @Test
    @org.jcheck.annotations.Generator(klass = SinglyLinkedList.class, generator = SinglyLinkedListGenerator.class)
    public void testReverse(SinglyLinkedList<Integer> list) {
        SinglyLinkedList reverse = SinglyLinkedListUtil.reverse(list);
        

    }

    public static class SinglyLinkedListGenerator implements Gen<SinglyLinkedList<Integer>> {
        private final IntegerGen intGen = new IntegerGen();
        @Override
        public SinglyLinkedList<Integer> arbitrary(Random random, long size) {
            size = intGen.arbitrary(random, size);
            SinglyLinkedList<Integer> result = null;
            for (int i = 0; i < size; i++)
                result = new SinglyLinkedList<>(intGen.arbitrary(random, size), result);
            return new SinglyLinkedList<>(result);
        }
    }
}
