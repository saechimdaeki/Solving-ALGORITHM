package 자바.leetcode.LeetCode1657;

import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] arr1 = new int[26], arr2 = new int[26];
        IntStream.range(0, word1.length()).forEachOrdered(i -> {
            arr1[word1.charAt(i) - 'a']++;
            arr2[word2.charAt(i) - 'a']++;
        });

        if (IntStream.range(0, 26).filter(i -> arr1[i] != arr2[i]).anyMatch(i -> arr1[i] == 0 || arr2[i] == 0)) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return IntStream.range(0, 26).noneMatch(i -> arr1[i] != arr2[i]);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("abc", "bca")); // true
        System.out.println(solution.closeStrings("a", "aa")); // false
        System.out.println(solution.closeStrings("cabbba", "abbccc")); // true
        System.out.println(solution.closeStrings("uau","ssx")); // false
    }
}