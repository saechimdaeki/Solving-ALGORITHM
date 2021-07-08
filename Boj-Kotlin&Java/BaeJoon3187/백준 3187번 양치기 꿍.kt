package BaeJoon3187

import java.util.*

private lateinit var arr:Array<CharArray>
private lateinit var visited:Array<BooleanArray>
private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
fun main() {
    val br=System.`in`.bufferedReader()
    val (r,c)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(r){ CharArray(c) }
    visited=Array(r){ BooleanArray(c) }
    var answer=Pair(0,0)
    (0 until r).forEach { i ->
        val line=br.readLine()
        line.indices.forEach { j ->
            arr[i][j]=line[j]
        }
    }
    (0 until r).forEach { i ->
        (0 until c)
            .asSequence()
            .filter { arr[i][it]!='#' && !visited[i][it] }
            .map { bfs(i, it,r,c) }
            .forEach { answer=Pair(answer.first+ it.first,answer.second+ it.second) }
    }
    println("${answer.first} ${answer.second}")
}
private fun bfs(x:Int,y:Int,r:Int,c:Int):Pair<Int,Int>{
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    visited[x][y]=true
    var (s,w)= arrayOf(0,0)
    while (q.isNotEmpty()){
        val (cx,cy)=q.poll()
        when {
            arr[cx][cy]=='v' -> w++
            arr[cx][cy]=='k' -> s++
        }
        (0 until 4).forEach { i ->
            val (nx,ny)= arrayOf(cx+dx[i],cy+dy[i])
            if(nx<0 || nx>=r || ny <0 || ny>=c) return@forEach
            if(!visited[nx][ny] && arr[nx][ny]!='#'){
                q.offer(Pair(nx,ny))
                visited[nx][ny]=true
            }
        }
    }
    return when {
        s>w -> Pair(s,0)
        else -> Pair(0,w)
    }
}