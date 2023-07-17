package 자바.LeetCode2433;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static int[] findArray(int[] pref) {
        IntStream.iterate(pref.length - 1, i -> i > 0, i -> i - 1).forEachOrdered(i -> pref[i] ^= pref[i - 1]);
        return pref;
    }

    public static void main(String[] args) {
        int[] array1 = findArray(new int[]{5, 2, 0, 3, 1});
        System.out.println(Arrays.toString(array1));// 5,7,2,3,2

        int[] array2 = findArray(new int[]{13});
        System.out.println(Arrays.toString(array2));// 13
    }
}
