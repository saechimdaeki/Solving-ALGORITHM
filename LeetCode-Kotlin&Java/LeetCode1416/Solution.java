package 자바.leetcode.LeetCode1416;

import java.util.Arrays;

class Solution {

    static int mod = 1000000007;

    public static int numberOfArrays(String s, int k) {
        int[] arr = new int[s.length()];
        Arrays.fill(arr, -1);
        return dfs(s, k, arr, 0);
    }

    private static int dfs(String s, int k, int[] arr, int index) {
        if (index == s.length()) return 1;
        if ('0' == s.charAt(index)) return 0;
        if (arr[index] != -1) return arr[index];

        long number = 0;
        int answer = 0;

        for (int i = index; i < s.length(); i++) {
            number = number * 10 + s.charAt(i) - '0';
            if (number > k) break;
            answer = (answer + dfs(s, k, arr, i + 1)) % mod;
        }
        arr[index] = answer;
        return arr[index];
    }

    public static void main(String[] args) {
        System.out.println(numberOfArrays("1000", 10000)); // 1
        System.out.println(numberOfArrays("1000", 10)); // 0
        System.out.println(numberOfArrays("1317", 2000)); // 8
    }
}