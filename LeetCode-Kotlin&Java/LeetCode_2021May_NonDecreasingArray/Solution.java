package LeetCode_2021May_NonDecreasingArray;

class Solution {
    public boolean checkPossibility(int[] nums) {
        int idx=0;
        int i=1;
        while (i<nums.length) {
            if(nums[i]<nums[i-1]) {
                idx++;
                if (idx > 1) return false;
                if (i-2<0 ||nums[i - 2] <= nums[i]) nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
            }
            i++;
        }
        return true;
    }
}
