package LeetCode1877;

import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        int max=Integer.MIN_VALUE;

        while(left<right){
            max=Math.max(max,nums[left]+nums[right]);
            left++;
            right--;
        }
        return max;
    }
}
