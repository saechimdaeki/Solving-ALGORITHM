package LeetCode1557

class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val list= arrayListOf<Int>()
        val visited=BooleanArray(n)
        edges.forEach { edge ->
            visited[edge[1]]=true
        }
        (0 until n).filterNotTo(list) { visited[it] }
        return list
    }
}