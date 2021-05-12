import java.util.*

private val dx= intArrayOf(0,0,1,-1)
private val dy= intArrayOf(1,-1,0,0)
private lateinit var grid:Array<CharArray>
private lateinit var visited:Array<BooleanArray>
fun main() {

    val br=System.`in`.bufferedReader()

    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    grid=Array(n){ CharArray(m) }
    visited=Array(n){ BooleanArray(m) }
    var (sx,sy)= intArrayOf(0,0)
    (0 until n).forEach { i ->
        val row=br.readLine()
        row.indices.forEach { j ->
            grid[i][j]=row[j]
            when {
                grid[i][j]=='I' -> {
                    sx=i
                    sy=j
                }
            }
        }
    }
    val q=LinkedList<Pair<Int,Int>>()
    q.offer(Pair(sx,sy))
    visited[sx][sy]=true
    var cnt=0
    while (q.isNotEmpty()){
        val (nowx,nowy)=q.poll()
        if(grid[nowx][nowy]=='P')
            cnt++
        for(i in 0 until 4){
            val nextx=nowx+dx[i]
            val nexty=nowy+dy[i]
            if(nextx<0 ||nextx>=n ||nexty<0 || nexty>=m) continue
            if(visited[nextx][nexty] || grid[nextx][nexty]=='X') continue
            q.offer(Pair(nextx,nexty))
            visited[nextx][nexty]=true
        }
    }
    println(when {
        cnt>0 -> cnt
        else -> "TT"
    })
}