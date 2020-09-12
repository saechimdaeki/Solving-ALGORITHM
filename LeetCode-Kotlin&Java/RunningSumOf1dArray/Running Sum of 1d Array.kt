package 릿코드.RunningSumOf1dArray

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val list= arrayListOf<Int>()
        var sum=0
        for(i in nums.indices)
        {
            sum+=nums[i]
            list.add(sum)
        }
        return list.toIntArray()
    }
}

fun main() {
    val s=Solution()
    val answer1=s.runningSum(intArrayOf(1,2,3,4))
    for(i in answer1)
        print("$i ")
    println()
    val answer2=s.runningSum(intArrayOf(1,1,1,1,1))
    for(i in answer2)
        print("$i ")
    println()
    val answer3=s.runningSum(intArrayOf(3,1,2,10,1))
    for(i in answer3)
        print("$i ")
}