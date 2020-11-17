package 백준

import kotlin.system.exitProcess


private fun preproces(s: String) : IntArray{
    val m=s.length
    val pi=IntArray(m)
    var j=0
    for(i in 1 until m){
        while (j>0 &&s[i]!=s[j]){
            j=pi[j - 1]
        }
        if(s[i]==s[j]){
            pi[i]=j+1
            j++
        }else{
            pi[i]=0
        }
    }
    return pi
}

fun main() {
    val br=System.`in`.bufferedReader()
    val string=br.readLine()
    val n=string.length
    val tmp= preproces(string)
    val count=IntArray(n + 1)
    for(i in 0 until n-1){
        count[tmp[i]]++
    }
    run{
        var i = n
        while (i != 0) {
            if (count[i] >= 1) {
                println(string.substring(0, i))
                exitProcess(0)
            }
            i = tmp.get(i - 1)
        }
    }
    println(-1)
}