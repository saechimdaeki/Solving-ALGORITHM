package 백준

import java.util.*

private lateinit var arr:Array<IntArray>
private lateinit var visited:Array<BooleanArray>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val (n,m)=br.readLine().split(" ").map { it.toInt() }
        arr=Array(n){ IntArray(m) }
        visited=Array(n){ BooleanArray(m) }
        for(i in 0 until n){
            val input=br.readLine()
            for(j in input.indices)
            {
                when {
                    input[j]=='#' -> arr[i][j]=1
                    else -> arr[i][j]=0
                }
            }
        }
        var answer=0
        for(i in 0 until n){
            for(j in 0 until m){
                if(arr[i][j]==1 && !visited[i][j]) {
                    answer++
                    bfs(i, j, n, m)
                }
            }
        }
        bw.write("$answer\n")
    }
    bw.flush()
}
private fun bfs(x:Int,y:Int,n:Int,m:Int){
    visited[x][y]=true
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    while (q.isNotEmpty()){
        val (nowx,nowy)=q.poll()
        for(i in 0 until 4){
            val (nx,ny)= intArrayOf(nowx+dx[i],nowy+dy[i])
            if(nx in 0 until n && ny in 0 until m && !visited[nx][ny] && arr[nx][ny]==1){
                q.offer(Pair(nx,ny))
                visited[nx][ny]=true
            }
        }
    }
}