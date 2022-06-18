package LeetCode1337

class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val list = mutableListOf<Pair<Int, Int>>()
        mat.indices.mapTo(list) { Pair(it,search(mat[it])+1) }
        list.sortWith { a, b -> a.second - b.second }
        val answer = Array(k){0}
        (0 until k).forEachIndexed(action = fun(_: Int, it: Int) {
            answer[it] = list[it].first
        })
        return answer.toIntArray()
    }

    private fun search(arr: IntArray): Int {
        var (left, right) = arrayOf(0, arr.size - 1)
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == 0 -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return left
    }
}

fun main() {
    val s = Solution()
    val answer1 = s.kWeakestRows(
        arrayOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1, 1)
        ), 3
    )
    answer1.forEach { i ->
        print("$i ")
    } // 2, 0, 3

    println()

    val answer2 = s.kWeakestRows(
        arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 0, 0, 0)
        ), 2
    )
    answer2.forEach { i ->
        print("$i ")
    } // 0, 2
}