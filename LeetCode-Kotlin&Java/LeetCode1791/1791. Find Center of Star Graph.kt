package LeetCode1791

class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val length=edges.size
        val map= mutableMapOf<Int,Int>()
        edges.forEach { edge ->
            edge.forEach { i ->
                when {
                    map.containsKey(i) -> map[i] = map[i]!! +1
                    else -> map[i]=1
                }

                if(map[i]!! >1)
                    return i
            }
        }
        return -1
    }
}