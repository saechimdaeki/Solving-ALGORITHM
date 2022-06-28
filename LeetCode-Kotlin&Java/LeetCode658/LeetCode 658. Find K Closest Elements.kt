package LeetCode658

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var (left,right) = arrayOf(0,arr.size-k)
        val list = mutableListOf<Int>()
        while (left<right){
            val mid = left+(right-left)/2
            when {
                x-arr[mid]>arr[mid+k]-x -> left=mid+1
                else -> right=mid
            }
        }
        (left until left+k step 1).mapTo(list) { arr[it] }
        return list
    }
}

fun main() {
    val s = Solution()
    val answer1 = s.findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 3)
    answer1.forEach { i ->
        print("$i ")
    } // 1,2,3,4
    println()

    val answer2 = s.findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, -1)
    answer2.forEach { i ->
        print("$i ")
    } //1,2,3,4

}