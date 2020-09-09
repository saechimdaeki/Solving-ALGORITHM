package 백준

import java.util.*

private lateinit var arr:Array<IntArray>
private lateinit var visited:Array<BooleanArray>
private var myTeam=0
private var enemyTeam=0
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
/* 문제 잘읽자 이문제는 세로가m이다....  */
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(m){ IntArray(n) } //w=0 b=1
    visited=Array(m){ BooleanArray(n) }
    for(i in 0 until m){
        val input=br.readLine()
        for(j in input.indices){
            if(input[j]=='W')
                arr[i][j]=0
            else
                arr[i][j]=1
        }
    }
    for(i in 0 until m){
        for(j in 0 until n){
            if(!visited[i][j])
                bfs(i,j,n,m)
        }
    }
    println("$myTeam $enemyTeam")
}
private fun bfs(x:Int,y:Int,n:Int,m:Int){
    val state=arr[x][y]
    visited[x][y]=true
    val q=LinkedList<Pair<Int,Int>>()
    var answer=1
    q.offer(Pair(x,y))
    while (q.isNotEmpty()){
        val (nowx,nowy)=q.poll()
        for(i in 0 until 4){
            val (nx,ny)= intArrayOf(nowx+dx[i],nowy+dy[i])
            if(nx in 0 until m && ny in 0 until n && !visited[nx][ny] &&arr[nx][ny]==state){
                q.offer(Pair(nx,ny))
                visited[nx][ny]=true
                answer++
            }
        }
    }
    if(state==0)
        myTeam+=(answer*answer)
    else
        enemyTeam+=(answer*answer)
}