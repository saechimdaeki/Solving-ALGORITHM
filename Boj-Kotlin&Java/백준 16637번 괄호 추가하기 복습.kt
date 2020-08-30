package 백준

import kotlin.math.max

private var s=""
private var n=0
private var answer=Int.MIN_VALUE
fun main() {
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    s=br.readLine()
    dfs(0,0)
    println(answer)
}
private fun dfs(idx:Int,now:Int){
    var tmp=' '
    if(idx>n-1){
        answer= max(answer,now)
        return
    }
    tmp = when (idx) {
        0 -> '+'
        else -> s[idx-1]
    }
    if(idx+2<n){
        val temp=calc(s[idx]-'0',s[idx+2]-'0',s[idx+1])
        dfs(idx+4, calc(now,temp,tmp))
    }
    dfs(idx+2,calc(now,s[idx]-'0',tmp))
}
private fun calc(a:Int,b:Int,op:Char):Int{
    return when (op) {
        '*' -> a*b
        '+' -> a+b
        else -> {
            a-b
        }
    }
}