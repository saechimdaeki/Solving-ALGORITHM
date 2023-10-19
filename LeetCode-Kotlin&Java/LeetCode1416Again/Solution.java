package 자바.leetcode.LeetCode1416Again;

import java.util.Arrays;

class Solution {
    static int div = 1000000007;
    public int numberOfArrays(String s, int k) {
        int[] arr = new int[s.length()];
        Arrays.fill(arr, -1);
        return dfs(s,k,arr,0);
    }

    private int dfs(String s, int k , int[] arr, int index) {
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(arr[index] != -1) return arr[index];

        long number = 0;
        int answer = 0;

        for(int i = index ; i<s.length(); i++) {
            number = number * 10 + (s.charAt(i) - '0');
            if (number > k) break;
            answer = (answer + dfs(s,k,arr, i+1)) % div;
        }
        arr[index] = answer;
        return answer;
    }
}