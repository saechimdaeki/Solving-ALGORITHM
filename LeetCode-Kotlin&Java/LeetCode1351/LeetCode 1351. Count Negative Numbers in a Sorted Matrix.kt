package LeetCode1351

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var ans=0
        grid.forEach { ints ->
            ans+=search(ints)
        }
        return ans
    }

    private fun search(arr: IntArray): Int {
        var (left, right) = arrayOf(0, arr.size - 1)
        var cnt = 0
        while (left<=right){
            val mid = right - (right-left)/2
            when {
                arr[mid]<0 -> {
                    cnt = arr.size -mid
                    right = mid-1
                }
                else -> left = mid+1
            }
        }
        return cnt
    }
}

fun main() {
    val s = Solution()
    println(
        s.countNegatives(
            arrayOf(
                intArrayOf(4, 3, 2, -1),
                intArrayOf(3, 2, 1, -1),
                intArrayOf(1, 1, -1, -2),
                intArrayOf(-1, -1, -2, -3)
            )
        )
    ) // 8

    println(s.countNegatives(arrayOf(intArrayOf(3, 2), intArrayOf(1, 0)))) // 0
}