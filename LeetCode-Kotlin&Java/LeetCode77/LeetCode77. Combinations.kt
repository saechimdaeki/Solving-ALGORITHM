package LeetCode77


class Solution {
    fun combine(n: Int, k: Int): MutableList<MutableList<Int?>> {
        var result: MutableList<MutableList<Int?>> = ArrayList()
        when {
            k > n || k < 0 -> {
                return result
            }
            k == 0 -> {
                result.add(ArrayList())
                return result
            }
            else -> {
                result = combine(n - 1, k - 1)
                result.forEach { list ->
                    list.add(n)
                }
                result.addAll(combine(n - 1, k))
                return result
            }
        }
    }
}