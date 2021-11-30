package LeetCode2023

class Solution {
    fun numOfPairs(nums: Array<String>, target: String): Int {
        var ans=0
        val map= mutableMapOf<String,Int>()
        nums.forEach { s ->
            when {
                map.containsKey(s) -> map[s]=map[s]!!+1
                else -> map[s]=1
            }
        }
        nums.forEach { num ->
            when {
                num.length < target.length -> {
                    when (num) {
                        target.substring(0,num.length) -> {
                            val tmp=target.substring(num.length)
                            when {
                                tmp==num -> ans+=map[tmp]!!-1
                                map.containsKey(tmp) -> ans+=map[tmp]!!
                            }
                        }
                    }
                }
            }
        }
        return ans
    }
}