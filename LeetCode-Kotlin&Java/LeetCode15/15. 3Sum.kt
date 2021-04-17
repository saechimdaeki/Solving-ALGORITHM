package LeetCode15

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val ans= mutableSetOf<ArrayList<Int>>()
        if(nums.isEmpty()||nums.size<3) return ans.toList()
        for(i in nums.indices){
            var (left,right)= intArrayOf(i+1,nums.size-1)
            if(left==nums.size) break
            while (left<right){
                val sum=nums[i]+nums[left]+nums[right]
                when {
                    sum==0 -> {
                        val list= arrayListOf<Int>()
                        list.add(nums[i])
                        list.add(nums[left])
                        list.add(nums[right])
                        ans.add(list)
                        left++
                        right--
                    }
                    sum<0 -> {
                        left++
                    }
                    else -> right--
                }
            }
        }
        return ans.toList()
    }
}