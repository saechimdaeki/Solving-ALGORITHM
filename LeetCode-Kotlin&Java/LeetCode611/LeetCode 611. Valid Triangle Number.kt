package LeetCode611

class Solution {
    fun triangleNumber(nums: IntArray): Int {
        nums.sort()
        var answer=0
        (nums.size-1 downTo 1 step 1).forEach { i ->
            var (left,right) = arrayOf(0,i-1)
            while (left<right){
                when {
                    nums[left]+nums[right]>nums[i] -> {
                        answer+=(right-left)
                        right--
                    }
                    else -> left++
                }
            }
        }
        return answer
    }
}

fun main() {
    val s = Solution()
    println(s.triangleNumber(intArrayOf(2,2,3,4))) //3

    println(s.triangleNumber(intArrayOf(4,2,3,4))) //4
}