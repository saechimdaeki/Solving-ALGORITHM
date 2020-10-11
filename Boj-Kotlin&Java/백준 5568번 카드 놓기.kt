package 백준
private val arr= arrayListOf<String>()
private val set= mutableSetOf<Int>()
private lateinit var visited:BooleanArray
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val k=br.readLine().toInt()
    visited= BooleanArray(n)
    repeat(n){
        arr.add(br.readLine())
    }
    dfs(0,k,"",n)
    println(set.size)
}
private fun dfs(cnt:Int,k:Int,string: String,n:Int){
    if(cnt==k){
        set.add(string.toInt())
        return
    }
    if(cnt>n) return
    for(i in 0 until n){
        if(visited[i]) continue
        visited[i]=true
        dfs(cnt+1,k,string+arr[i],n)
        visited[i]=false
    }
}