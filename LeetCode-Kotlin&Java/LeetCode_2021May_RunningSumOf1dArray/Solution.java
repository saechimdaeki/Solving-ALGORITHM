package LeetCode_2021May_RunningSumOf1dArray;

import java.util.stream.IntStream;

class Solution {
    public int[] runningSum(int[] nums) {
        IntStream.range(1, nums.length).forEach(i -> nums[i] += nums[i - 1]);
        return nums;
    }
}
