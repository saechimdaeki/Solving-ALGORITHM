package 백준

private var answer=0
fun main() {
    val n= readLine()!!.toInt()
    (1..2)
            .forEach { i ->
                dfs(i,i,n)
            }
    println(answer)
}
private fun dfs(number:Int,sum:Int,n:Int){
    when {
        n==1 && sum%3==0 -> {
            answer++
            return
        }
        n==1 -> {
            return
        }
        else -> {
            (0..2).forEach { i ->
                dfs(number, sum + i, n - 1)
            }
            return
        }
    }
}