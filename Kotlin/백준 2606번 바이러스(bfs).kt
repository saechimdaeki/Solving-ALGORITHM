import java.util.*

private lateinit var arr:Array<Array<Int>>
private lateinit var visited:Array<Boolean>
/* bfs식풀이 */
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    arr=Array(n+1){Array(n+1){0}}
    visited=Array(n+1){false}
    for(i in 0 until m)
    {
        val (from,to)=br.readLine().split(" ")
                .map { it.toInt() }
        arr[from][to]=1
        arr[to][from]=1
    }
    val q=LinkedList<Int>()
    q.offer(1)
    visited[1]=true
    var answer=0
    while (q.isNotEmpty())
    {
        val now=q.poll()
        for(i in 1..n)
            if(arr[now][i]==1 && !visited[i])
            {
                answer++
                q.offer(i)
                visited[i]=true
            }
    }
    println(answer)

}