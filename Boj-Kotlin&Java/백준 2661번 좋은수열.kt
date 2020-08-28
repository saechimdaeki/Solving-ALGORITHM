package 백준

import kotlin.system.exitProcess

fun main() {
    val n=System.`in`.bufferedReader().readLine().toInt()
    dfs("",n)
}
private fun dfs(s:String,n:Int){
    if(s.length==n){
        println(s)
        exitProcess(0)
    }else{
        for(i in 1..3){
            if(check(s+i)){
                dfs(s+i,n)
            }
        }
    }
}
private fun check(s:String):Boolean{
    for(i in 1..s.length/2){
        if(s.substring(s.length-i)==s.substring(s.length-2*i,s.length-i))
            return false
    }
    return true
}