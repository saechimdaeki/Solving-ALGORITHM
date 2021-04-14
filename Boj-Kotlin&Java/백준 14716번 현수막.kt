import java.util.*

private lateinit var graph:Array<IntArray>
private lateinit var visited:Array<BooleanArray>
private val dx= intArrayOf(-1,0,1,-1,1,-1,0,1)
private val dy= intArrayOf(1,1,1,0,0,-1,-1,-1)
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (m,n)=br.readLine().split(" ").map { it.toInt() }
    graph=Array(m){ IntArray(n)}
    visited=Array(m){ BooleanArray(n) }
    (0 until m).forEach { i ->
        graph[i]=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    for(i in 0 until m){
        (0 until n).forEach { j ->
            if(graph[i][j]!=0 && !visited[i][j]) {
                dfs(i, j,m,n)
                answer++
            }
        }
    }
    print(answer)
}
private fun dfs(y:Int,x:Int,m:Int,n:Int){
    visited[y][x]=true
    for(i in 0 until 8){
        val (nx,ny)= arrayOf(x+dx[i],y+dy[i])
        if(nx in 0 until n && ny in 0 until m && graph[ny][nx]!=0 &&!visited[ny][nx]){
            visited[ny][nx]=true
            dfs(ny,nx,m,n)
        }
    }
}