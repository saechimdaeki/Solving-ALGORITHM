package 백준
private var answer=0
fun main() {
    val (n,k)= readLine()!!.split(" ").map { it.toInt() }
    dfs(n,k)
    println("$answer")
}
private fun dfs(n:Int,k:Int){
    if(n<2+k ||(n+k)%2==1){
        answer++
        return
    }
    dfs((n+k)/2,k)
    dfs((n-k)/2,k)
}