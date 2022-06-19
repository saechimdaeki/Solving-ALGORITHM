package LeetCode350

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val map = mutableMapOf<Int,Int>()
        nums1.forEachIndexed { _, i -> map[i] = map.getOrDefault(i, 0) + 1 }
        nums2.indices.forEachIndexed { _, i ->
            map[nums2[i]]?.let {
                answer.add(nums2[i])
                when (it) {
                    1 -> map.remove(nums2[i])
                    else -> map[nums2[i]] = it - 1
                }
            }
        }
        return answer.toIntArray()
    }
}

fun main() {
    val s = Solution()
    val answer1 = s.intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    for (i in answer1) {
        print("$i ")
    } // 2, 2
    println()

    val answer2 = s.intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
    for (i in answer2) {
        print("$i ")
    }// 4, 9
}