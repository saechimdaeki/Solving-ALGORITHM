package boj2667

import java.util.LinkedList

val dx = intArrayOf(0,0,1,-1)
val dy = intArrayOf(1,-1,0,0)
fun main() {
    val n = readLine()!!.toInt()
    val map = Array(n) { readLine()!!.toCharArray() }
    val visited = Array(n) { BooleanArray(n) }
    var answer = 0
    val answerlist= mutableListOf<Int>()
    for(i in 0 until n) {
        for(j in 0 until n) {
            if(map[i][j] =='1' && !visited[i][j]) {
                answer++
                val q = LinkedList<Pair<Int,Int>>()
                q.add(Pair(i,j))
                visited[i][j] = true
                var cnt = 1
                while(q.isNotEmpty()) {
                    val (nowx,nowy) = q.poll()
                    for(k in 0 until 4) {
                        val nx = nowx+ dx[k]
                        val ny = nowy +dy[k]
                        if(nx<0 || nx>=n || ny<0 || ny>=n) continue
                        if(map[nx][ny] == '1' && !visited[nx][ny]) {
                            q.add(Pair(nx,ny))
                            cnt++
                            visited[nx][ny] = true
                        }
                    }
                }
                answerlist.add(cnt)
            }
        }
    }
    println(answer)
    answerlist.sort()
    answerlist.forEach { println(it)}
}