package LeetCode1827

class Solution {
    fun minOperations(nums: IntArray): Int {
        var ans=0
        for(i in 0 until nums.size-1){
            if(nums[i]>=nums[i+1]){
                val tmp=nums[i+1]
                nums[i+1]=nums[i]+1
                ans+=(nums[i+1]-tmp)
            }
        }
        return ans
    }
}