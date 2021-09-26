package LeetCode16;


import java.util.Arrays;

/**
 * 16. 3Sum Closest leetCode
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int inf=987654321;
        for(int i=0; i<nums.length-2; i++){ //3
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                inf = Math.abs(target -sum)<Math.abs(inf) ? target-sum : inf;
                if(sum<target)
                    left++;
                else
                    right--;
            }
        }
        return target-inf;
    }
}
