package com.moon.binarySearch;

/**
 * Like {@link BinarySearch2006}, but with "same items" fix.
 *
 * @author John Doe
 * @version 4.0
 * @since December 2007
 */
public class BinarySearch2007 implements BinarySearch {
    @Override
    public int execute(byte[] haystack, byte needle) {
        int left = 0;
        int right = haystack.length;

        while (left < right) {
            if (haystack[left] == needle)
                return left;

            int mid = (left + right) / 2;

            if (haystack[mid] == needle) {
                if (mid == left + 1)
                    return mid;
                else
                    right = mid + 1;
                continue;
            }

            if (haystack[mid] > needle)
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }
}
