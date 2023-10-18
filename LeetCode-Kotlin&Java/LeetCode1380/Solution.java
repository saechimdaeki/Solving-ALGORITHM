package 자바.leetcode.LeetCode1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 1380. Lucky Numbers in a Matrix (최적화 필요) TODO*/
class Solution {
    public static List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answerList = new ArrayList<>();
        List<Integer> rowList = Arrays.stream(matrix).map(ints -> Arrays.stream(ints).min().getAsInt()).toList();

        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int[] ints : matrix) {
                max = Math.max(max, ints[i]);
            }
            if (rowList.contains(max)) answerList.add(max);
        }
        return answerList;
    }

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}})); // [15]
        System.out.println(luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}})); // [12]
        System.out.println(luckyNumbers(new int[][]{{7, 8}, {1, 2}})); // [7]
    }
}