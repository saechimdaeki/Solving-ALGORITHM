package 백준

import kotlin.math.max

private val arr= arrayListOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ").map { it.toInt() }
    for(i in input.indices){
        arr.add(input[i])
    }
    println("${dfs(arr)}")
}
private fun dfs(a:ArrayList<Int>):Int{
   val n=a.size
    var answer=0
    if(n<=2)
        return 0
    for(i in 1 until n-1){
        var energy=a[i-1]*a[i+1]
        val tmp=ArrayList(a)
        tmp.removeAt(i)
        energy+=dfs(tmp)
        answer= max(answer,energy)
    }
    return answer
}