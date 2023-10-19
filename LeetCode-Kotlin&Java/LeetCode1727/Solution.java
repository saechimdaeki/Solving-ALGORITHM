package 자바.leetcode.LeetCode1727;

import java.util.Arrays;

class Solution {
    public static int largestSubmatrix(int[][] matrix) {
        int answer = 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0)
                    matrix[i][j] = matrix[i - 1][j] + 1;
            }
        }

        for (int[] ints : matrix) {
            Arrays.sort(ints);
            for (int j = 0; j < matrix[0].length; j++)
                answer = Math.max(answer, ints[j] * (matrix[0].length - j));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}})); // 4
        System.out.println(largestSubmatrix(new int[][]{{1, 0, 1, 0, 1}})); // 3
        System.out.println(largestSubmatrix(new int[][]{{1, 1, 0}, {1, 0, 1}})); // 2
    }
}