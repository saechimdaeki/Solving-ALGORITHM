package LeetCode1855

class Solution {
    fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
        val answer = mutableListOf<Int>()
        nums1.indices.forEachIndexed { _, it -> answer.add(search(nums2, it, nums1[it]) - it) }
        return when {
            answer.maxOf { it } < 0 -> 0
            else -> answer.maxOf { it }
        }
    }

    fun search(arr :IntArray , tmp : Int , target : Int) :Int{
        var (left, right) = arrayOf(tmp, arr.size-1)
        var idx=-1
        while (left<=right) {
            val mid = left + (right-left)/2
            when {
                target>arr[mid] -> right=mid-1
                else -> {
                    idx = mid
                    left= mid+1
                }
            }
        }
        return idx
    }
}

fun main() {
    val s = Solution()
    println(s.maxDistance(intArrayOf(55,30,5,4,2), intArrayOf(100,20,10,10,5))) // 2

    println(s.maxDistance(intArrayOf(2,2,2), intArrayOf(10,10,1))) // 1

    println(s.maxDistance(intArrayOf(30,29,19,5), intArrayOf(25,25,25,25,25))) // 2
}