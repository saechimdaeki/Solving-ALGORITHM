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


fun main() {
    val s = Solution()
    val solve1 = s.twoSum(intArrayOf(2,7,11,15),9)
    for (i in solve1) {
        print("$i ")
    } // 1, 2

    println()

    val solve2 = s.twoSum(intArrayOf(2,3,4),6)
    for (i in solve2) {
        print("$i ")
    } // 1,3

    println()

    val solve3 = s.twoSum(intArrayOf(-1,0),-1)
    for (i in solve3) {
        print("$i ")
    } // 1,2
}