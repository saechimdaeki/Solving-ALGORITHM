package LeetCode27

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
       var cnt=0
        for (i in nums.indices) {
            if(nums[i]!=`val`){
                val abc=nums[i]
                nums[i]=`val`
                nums[cnt++]=abc
            }
        }
        return cnt
    }
}

