package LeetCode567


class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        when {
            s1.length > s2.length -> return false
            else -> {
                val arr1 = IntArray(26) { 0 }
                val arr2 = IntArray(26) { 0 }
                s1.indices.forEach { i ->
                    arr1[s1[i] - 'a']++
                    arr2[s2[i] - 'a']++
                }
                when {
                    arr1.contentEquals(arr2) -> return true
                    else -> {
                        var (left, right) = arrayOf(0, s1.length)
                        while (right < s2.length) {
                            arr2[s2[left] - 'a']--
                            arr2[s2[right] - 'a']++
                            when {
                                arr1.contentEquals(arr2) -> return true
                                else -> {
                                    left++
                                    right++
                                }
                            }
                        }
                        return false
                    }
                }

            }
        }

    }
}

fun main() {
    Solution().also {
        println(it.checkInclusion("ab","eidbaooo")) // true
        println(it.checkInclusion("ab","eidboaoo")) // false
    }
}