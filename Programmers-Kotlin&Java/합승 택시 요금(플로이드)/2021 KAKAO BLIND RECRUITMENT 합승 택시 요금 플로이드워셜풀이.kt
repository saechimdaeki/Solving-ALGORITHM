package kakao


class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val graph=Array(n+1){IntArray(n+1){10000001}}
        for (i in 1 until n+1) {
           for(j in 1 until n+1){
               if(i==j) graph[i][j]=0
           }
        }
        fares.indices.forEach { i ->
            graph[fares[i][0]][fares[i][1]]=fares[i][2]
            graph[fares[i][1]][fares[i][0]]=fares[i][2]
        }
        (1 until n+1).forEach { k ->
            (1 until n+1).forEach { i ->
                for (j in 1 until n+1) {
                    if(graph[i][j]>graph[i][k]+graph[k][j])   //foreach시 시간초과..
                        graph[i][j]=graph[i][k]+graph[k][j]
                }
            }
        }
        var answer=Int.MAX_VALUE
        (1 until n+1).forEach { i ->
            answer= minOf(answer,graph[s][i]+graph[i][a]+graph[i][b])
        }
        return answer
    }
}

fun main() {
    val s= Solution()
    println("${s.solution(6,4,6,2, arrayOf(intArrayOf(4,1,10), intArrayOf(3,5,24), intArrayOf(5,6,2), intArrayOf(3,1,41), intArrayOf(5,1,24), intArrayOf(4,6,50), intArrayOf(2,4,66), intArrayOf(2,3,22), intArrayOf(1,6,25)))}")
    println("${s.solution(7,3,4,1, arrayOf(intArrayOf(5,7,9), intArrayOf(4,6,4), intArrayOf(3,6,1), intArrayOf(3,2,3), intArrayOf(2,1,6)))}")
    println("${s.solution(6,4,5,6, arrayOf(intArrayOf(2,6,6), intArrayOf(6,3,7), intArrayOf(4,6,7), intArrayOf(6,5,11), intArrayOf(2,5,12), intArrayOf(5,3,20), intArrayOf(2,4,8), intArrayOf(4,3,9)))}")
}