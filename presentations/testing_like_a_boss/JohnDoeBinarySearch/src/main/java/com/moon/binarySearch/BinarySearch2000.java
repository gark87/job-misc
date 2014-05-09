package com.moon.binarySearch;

/**
 * @author John Doe The Programmer
 * @version 1.0
 * @since June 2000
 */
public class BinarySearch2000 implements Search {
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
