package 백준

import java.util.*
import kotlin.system.exitProcess
private lateinit var visited:Array<BooleanArray>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private lateinit var grid:Array<IntArray>
fun main() { //실수 그만하자..
    val (n,m)= readLine()!!.split(" ").map { it.toInt() }
    grid=Array(n){IntArray(m)}
    visited=Array(n){ BooleanArray(m) }
    for(i in 0 until n){
        val input= readLine()
        for(j in input!!.indices){
            grid[i][j]=input[j]-'0'
        }
    }
        for(j in 0 until m){
            if(grid[0][j]==0 && !visited[0][j]){
              //  println("$j 번째 시작")
                bfs(j,n,m)
             //   println("======================")
            }
        }
    println("NO")
}
private fun bfs(y:Int,n:Int,m:Int){
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(0,y))
    visited[0][y]=true
    while (q.isNotEmpty()){
        val (nowx,nowy)=q.poll()
        //println("${nowx} ${nowy}")
        if(nowx==n-1){
            println("YES")
            exitProcess(0)
        }
        for(i in 0 until 4){
            val (nx,ny)= intArrayOf(nowx+dx[i],nowy+dy[i])
            if(nx in 0 until n && ny in 0 until m && !visited[nx][ny] && grid[nx][ny]==0){
                q.offer(Pair(nx,ny))
                visited[nx][ny]=true
            }
        }
    }
}
