import java.util.*

private lateinit var grid:Array<IntArray>
private lateinit var visited:Array<BooleanArray>

private val dx= intArrayOf(-1,0,1,-1,1,-1,0,1)
private val dy= intArrayOf(1,1,1,0,0,-1,-1,-1)
private var cnt=0
fun main() {
    val br= System.`in`.bufferedReader()
    val (n,m)= br.readLine().split(" ").map { it.toInt() }
    grid = Array(n){IntArray(m)}
    visited=Array(n){BooleanArray(m)}
    (0 until n).forEach { it -> grid[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    (0 until n).forEach { i ->
        (0 until m)
            .asSequence()
            .filterNot { visited[i][it] }
            .forEach { bfs(i, it,n,m) }
    }
    println(cnt)


}

fun bfs(x: Int, y: Int, n: Int, m: Int) {
    val q= LinkedList<Pair<Int,Int>>()
    q.offer(Pair(x,y))
    var check=true
    while (q.isNotEmpty()){
        val now = q.poll()
        val (nowX,nowY) = arrayOf(now.first,now.second)
        (0 until 8).forEach { i ->
            val nextX = nowX+dx[i]
            val nextY = nowY+dy[i]
            when {
                nextX<0 || nextX>=n || nextY<0 || nextY>=m -> return@forEach
                grid[nowX][nowY] < grid[nextX][nextY] -> check=false
            }
            when {
                grid[nowX][nowY] != grid[nextX][nextY] -> return@forEach
                !visited[nextX][nextY] -> {
                    q.offer(Pair(nextX,nextY))
                    visited[nextX][nextY]=true
                }
            }
        }
    }
    if(check) cnt++
}
