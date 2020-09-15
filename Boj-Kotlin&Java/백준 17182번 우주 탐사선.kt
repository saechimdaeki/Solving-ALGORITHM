import kotlin.math.min

private lateinit var arr:Array<IntArray>
private lateinit var visited:BooleanArray
private var answer=1000000000
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,t)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){ IntArray(n) }
    visited= BooleanArray(n)
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    visited[t]=true
    dfs(t,0,1,n)
    println("$answer")
}
private fun dfs(idx:Int, dist:Int, cnt:Int,n:Int){
    if(answer<dist) return
    if(cnt==n){
        answer= min(answer,dist)
        return
    }
    for(i in 0 until n){
        if(visited[i]) continue
        visited[i]=true
        dfs(i,arr[idx][i]+dist,cnt+1,n)
        visited[i]=false
    }
}