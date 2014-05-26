package com.moon.binarySearch;

/**
 * Like {@link BinarySearch2001}, but with "missing item" fix.
 *
 * @author John Doe The Programmer
 * @version 3.0
 * @since July 2006
 */
public class BinarySearch2006 implements Search {
    @Override
    public int execute(byte[] haystack, byte needle) {
        int left = 0;
        int right = haystack.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (haystack[mid] == needle)
                return mid;

            if (haystack[mid] > needle)
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }
}
