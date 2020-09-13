package 백준

import java.util.*

private lateinit var arr:Array<IntArray>
private lateinit var dist:Array<IntArray>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){ IntArray(n) }
    dist=Array(n){ IntArray(n){100000000} }
    for(i in 0 until n){
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]-'0'
    }
    bfs(n)
    println("${dist[n-1][n-1]}")
}
private fun bfs(n:Int){
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(0,0))
    dist[0][0]=0
    while (q.isNotEmpty()){
        val (x,y)=q.poll()
        for(i in 0 until 4){
            val (nx,ny)= intArrayOf(x+dx[i],y+dy[i])
            if(nx in 0 until n && ny in 0 until n){
                if(arr[nx][ny]==1){
                    if(dist[nx][ny]>dist[x][y]){
                        dist[nx][ny]=dist[x][y]
                        q.offer(Pair(nx,ny))
                    }
                }else{
                    if(dist[nx][ny]>dist[x][y]+1){
                        dist[nx][ny]=dist[x][y]+1
                        q.offer(Pair(nx,ny))
                    }
                }
            }
        }
    }
}