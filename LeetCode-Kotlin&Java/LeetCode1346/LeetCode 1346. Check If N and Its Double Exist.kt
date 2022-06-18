package LeetCode1346

class Solution {
    fun checkIfExist(arr: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        arr.forEachIndexed { _, i ->
            when {
                set.contains(i * 2) -> return true
                else -> when {
                    i % 2 == 0 && set.contains(i / 2) -> return true
                    else -> set.add(i)
                }
            }
        }
        return false
    }
}


fun main() {
    val s = Solution()
    println(s.checkIfExist(intArrayOf(10, 2, 5, 3))) // true

    println(s.checkIfExist(intArrayOf(7, 1, 14, 11))) // true

    println(s.checkIfExist(intArrayOf(3, 1, 7, 11))) // false
}