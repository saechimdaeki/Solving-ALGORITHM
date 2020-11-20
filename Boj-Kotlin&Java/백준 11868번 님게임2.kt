package 백준

import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    var answer=0
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }
    for (i in arr) {
        answer = answer xor i
    }
    if(answer==0){
        println("cubelover")
        exitProcess(0)
    }
    println("koosaga")
}