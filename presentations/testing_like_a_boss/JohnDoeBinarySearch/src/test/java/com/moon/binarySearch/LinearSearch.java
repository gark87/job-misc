package com.moon.binarySearch;

/**
 * To find element in array.
 *
 * @author John Doe The Programmer
 * @version 1.0
 * @since June 2000
 */
public class LinearSearch implements Search {
    @Override
    public int execute(byte[] haystack, byte needle) {
        for (int i = 0; i < haystack.length; i++) {
            if (needle == haystack[i])
                return i;
        }
        return -1;
    }
}
