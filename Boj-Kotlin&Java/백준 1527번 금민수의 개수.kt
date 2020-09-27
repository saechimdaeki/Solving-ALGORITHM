package 백준
private var answer=0
fun main() {
    val (a,b)= readLine()!!.split(" ").map { it.toInt() }
    dfs(0,0,a,b)
    println(answer)
}
/* 생각을 잘하자. */
private fun dfs(now:Int,cnt:Int,a:Int,b:Int){
    if(cnt>=10) return
    if(now>b) return
    if(now>=a) answer++
    dfs(now*10+4,cnt+1,a,b)
    dfs(now*10+7,cnt+1,a,b)
}