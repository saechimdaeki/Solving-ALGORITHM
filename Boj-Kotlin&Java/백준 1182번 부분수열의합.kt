package 백준

private lateinit var arr:IntArray
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,s)=br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    dfs(0,n,s,0)
    if(s==0)
        answer-=1
    println(answer)
}
private fun dfs(idx:Int,n:Int,s:Int,sum:Int){
    if(idx==n){
        if(sum==s)
            answer++
        return
    }
    dfs(idx+1,n,s,sum+arr[idx])
    dfs(idx+1,n,s,sum)
}