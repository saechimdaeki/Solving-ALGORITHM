package 백준

import java.util.*

private var answer=0
private lateinit var arr:Array<IntArray>
private val dx= intArrayOf(1,-1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private lateinit var visited:Array<Array<IntArray>>
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m,t)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){ IntArray(m) }
    visited=Array(n){Array(m){ IntArray(2) } }
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    bfs(0,0,0,0,n,m,t)
    when (answer) {
        in 1..t -> println("$answer")
        else -> println("Fail")
    }
}
private fun bfs(x:Int,y:Int,cnt:Int,sword:Int,n:Int,m:Int,t:Int){
    val q=LinkedList<node17836>()
    q.offer(node17836(x,y,cnt,sword))
    visited[x][y][sword]=1
    while (q.isNotEmpty()){
        var (nowx,nowy,nowcnt,nowsword)=q.poll()
        if(arr[nowx][nowy]==2)
            nowsword=1
        if(nowx==n-1 && nowy==m-1){
            answer=nowcnt
            return
        }
        for(i in 0 until 4){
            val (nx,ny)= intArrayOf(nowx+dx[i],nowy+dy[i])
            if(nowsword==1){
                if(nx in 0 until n && ny in 0 until m && visited[nx][ny][nowsword]==0){
                    visited[nx][ny][nowsword]=nowcnt+1
                    q.offer(node17836(nx,ny, visited[nx][ny][nowsword],nowsword))
                }
            }else{
                if(nx in 0 until n && ny in 0 until m && visited[nx][ny][nowsword]==0 && arr[nx][ny]!=1)
                {
                    visited[nx][ny][nowsword]=nowcnt+1
                    q.offer(node17836(nx,ny, visited[nx][ny][nowsword],nowsword))
                }
            }
        }
    }
}
private data class node17836(val x:Int,val y:Int,val cnt:Int,val sword:Int)
