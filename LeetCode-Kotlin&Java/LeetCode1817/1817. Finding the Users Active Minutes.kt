package LeetCode1817

class Solution {
    fun findingUsersActiveMinutes(logs: Array<IntArray>, k: Int): IntArray {
        val answer=IntArray(k)
        val map= mutableMapOf<Int,HashSet<Int>>()
        for (log in logs) {
            val (id,time)= arrayOf(log[0],log[1])
            if(map[id]==null) map[id]=HashSet()
            map[id]!!.add(time)
        }
        map.forEach { entry ->
            when {
                entry.value.size-1<=k -> answer[entry.value.size-1]++
            }
        }
        return answer
    }
}