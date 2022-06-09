package com.find_missing_positive_integer;
import java.util.List;

/**
 * to find the smallest missing positive integer.
 */
public class FindMissingPositiveInteger {
    /**
     * to find the smallest missing positive integer.
     * in an array.
     * @param arrayOfInteger array of integers.
     * @return return smallest missing integer.
     */
    public int findMissingPositiveInteger(final List<Integer> arrayOfInteger) {
        // for removing negative integers
        for (int index = 0; index < arrayOfInteger.size(); index++) {
            if (arrayOfInteger.get(index) < 0) {
                arrayOfInteger.set(index, 0);
            }
        }
        // mark visited elements by making
        // -ve sign(multiple by -1) if element > 0
        // -ve sign(adding 1 and then multiple by -1) if element==0
        // from 0 and positive numbers start from 1
        for (int index = 0; index < arrayOfInteger.size(); index++) {
            int value = Math.abs(arrayOfInteger.get(index));
            if (value >= 1 && value <= arrayOfInteger.size()) {
                if (arrayOfInteger.get(value - 1) > 0) {
                    arrayOfInteger.set(value - 1,
                            arrayOfInteger.get(value - 1) * -1);
                } else if (arrayOfInteger.get(value - 1) == 0) {
                    arrayOfInteger.set(value - 1,
                            -1 * (arrayOfInteger.size() + 1));
                }
            }
        }
        for (int index = 1; index <= arrayOfInteger.size(); index++) {
            if (arrayOfInteger.get(index - 1) >= 0) {
                return index;
            }
        }
        return arrayOfInteger.size() + 1;
    }
}
