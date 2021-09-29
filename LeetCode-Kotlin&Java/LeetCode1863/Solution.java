package LeetCode1863;

/* 1863. Sum of All Subset XOR Totals */
class Solution {
    public int subsetXORSum(int[] nums) {
        return track(nums,0,0);
    }
    public int track(int[] nums, int idx, int now){
        if(idx==nums.length) return now;

        int a=track(nums,idx+1,now^nums[idx]);
        int b=track(nums,idx+1,now);
        return a+b;
    }
}
