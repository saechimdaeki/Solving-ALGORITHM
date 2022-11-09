package LeetCode167

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var (left,right) = arrayOf(0,numbers.size-1)
        while (left<right){
            val sum = numbers[left]+numbers[right]
            when {
                sum==target -> return intArrayOf(left+1, right+1)
                sum>target -> right--
                else -> left++
            }
        }
        return intArrayOf(-1,-1)
    }
}