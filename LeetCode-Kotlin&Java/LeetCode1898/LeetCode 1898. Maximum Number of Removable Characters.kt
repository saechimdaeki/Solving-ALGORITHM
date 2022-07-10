package LeetCode1898

class Solution {
    fun maximumRemovals(s: String, p: String, removable: IntArray): Int {
        var (left, right) = arrayOf(0, removable.size - 1)
        while (left <= right) {
            val mid = left + (right - left) / 2
            StringBuilder(s).apply {
                (0..mid).forEach { i -> this.setCharAt(removable[i], ' ') }
                when {
                    !check(this.toString(), p) -> right = mid - 1
                    else -> left = mid + 1
                }
            }
        }
        return right + 1
    }

    private fun check(s: String, p: String) = run {
        var (i, j) = arrayOf(0, 0)
        while (i < p.length && j < s.length) {
            when {
                p[i] == s[j] -> {
                    i++
                }
            }
            j++
        }
        i == p.length
    }
}

fun main() {
    Solution().apply {
        println(maximumRemovals("abcacb", "ab", intArrayOf(3, 1, 0))) //2
        println(maximumRemovals("abcbddddd", "abcd", intArrayOf(3, 2, 1, 4, 5, 6))) //1
    }
}