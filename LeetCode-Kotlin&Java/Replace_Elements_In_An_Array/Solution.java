package 자바.leetcode.Replace_Elements_In_An_Array;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> valueIndexMap = IntStream.range(0, nums.length).boxed()
                .collect(Collectors.toMap(i -> nums[i], i -> i, (a, b) -> b));
        Arrays.stream(operations).forEach(operation -> {
            int index = valueIndexMap.get(operation[0]);
            nums[index] = operation[1];
            valueIndexMap.remove(operation[0]);
            valueIndexMap.put(operation[1], index);
        });
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayChange(new int[]{1,2,4,6}, new int[][]{{1,3},{4,7},{6,1}}))); // [3,2,7,1]
        System.out.println(Arrays.toString(arrayChange(new int[]{1,2},new int[][]{{1,3},{2,1},{3,2}}))); // [2,1]
    }
}