package 백준

import java.util.*

private lateinit var arr:Array<IntArray>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private lateinit var visited:Array<BooleanArray>
private val list= arrayListOf<Int>()
fun main() {
    val (n,m,k)= readLine()!!.split(" ").map{it.toInt()}
    arr=Array(n+1){ IntArray(m+1) }
    visited=Array(n+1){ BooleanArray(m+1) }
    repeat(k){
        val (x,y)= readLine()!!.split(" ").map { it.toInt() }
        arr[x][y]=1
    }
    for(i in 1..n){
        for(j in 1..m){
            if(!visited[i][j] && arr[i][j]==1){
                bfs(i,j,n,m)
            }
        }
    }
    println(list.max())
}
private fun bfs(x:Int,y:Int,n:Int,m:Int){
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    visited[x][y]=true
    var answer=1
    while (q.isNotEmpty()){
        val (nowx,nowy)=q.poll()
        for(i in 0 until 4){
            val (nx,ny)= intArrayOf(nowx+dx[i],nowy+dy[i])
            if(nx in 1..n && ny in 1..m &&!visited[nx][ny]&&arr[nx][ny]==1){
                visited[nx][ny]=true
                q.offer(Pair(nx,ny))
                answer++
            }
        }
    }
    list.add(answer)
}