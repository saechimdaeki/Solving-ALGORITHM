package 코틀린.LeetCode.LeetCode2178

class Solution {
    val list = mutableListOf<MutableList<Long>>()
    fun maximumEvenSplit(finalSum: Long): List<Long> {
        if (finalSum % 2 != 0L) return listOf()
        // 짝수만 ... !
        dfs(finalSum, mutableListOf(), 2)
        return list.maxBy { it.size }
    }

    fun dfs(target: Long, current: MutableList<Long>, now: Long) {
        if (target == 0L) {
            list.add(current)
            return
        }

        for (i in now..target step 2) {
            current.add(i)
            dfs(target - i , current , now + 2)
            if(list.isNotEmpty()) return
            current.removeAt(current.size-1)
        }
    }
}

fun main() {
    Solution().apply {
        println(maximumEvenSplit(12).toString()) // [2,4,6]
        println(maximumEvenSplit(7).toString()) // []
        println(maximumEvenSplit(28).toString()) // [6,8,2,12]
    }
}