package com.moon.binarySearch;

/**
 * Exactly like {@link BinarySearch2000}.
 *
 * @author John Doe The Programmer
 * @version 2.0
 * @since May 2001
 */
public class BinarySearch2001 implements Search {
    @Override
    public int execute(byte[] haystack, byte needle) {
        int left = 0;
        int right = haystack.length;

        while (true) {
            int mid = (left + right) / 2;

            if (haystack[mid] == needle)
                return mid;

            if (haystack[mid] > needle)
                right = mid;
            else
                left = mid + 1;
        }
    }
}
