package com.moon.dna;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Naive Trie implementation
 *
 * @author John Doe The Programmer
 */
public class Trie {
    private final Node root = new Node();
    private static final Pattern VALID_DNA = Pattern.compile("^[ATCG]+$");

    public void add(String text) {
        if (!VALID_DNA.matcher(text).matches())
            throw new IllegalArgumentException("Not a DNA");
        Node node = root;
        for (int i = 0; i < text.length(); i++)
            node = node.createIfNeeded(text.charAt(i));
    }

    public Set<String> getAllStrings() {
        return root.getAll();
    }

    private static class Node {
        private final SortedMap<Character, Node> children = new TreeMap<>();
        private final static Set<String> EMPTY = Collections.singleton("");

        public Node createIfNeeded(char c) {
            Node result = children.get(c);
            if (result == null)
                children.put(c, result = new Node());
            return result;
        }

        public Set<String> getAll() {
            Set<String> result = new TreeSet<>();
            if (children.isEmpty())
                return EMPTY;
            for (Map.Entry<Character, Node> entry : children.entrySet()) {
                for (String string : entry.getValue().getAll())
                    result.add(entry.getKey() + string);
            }
            return result;
        }
    }
}
