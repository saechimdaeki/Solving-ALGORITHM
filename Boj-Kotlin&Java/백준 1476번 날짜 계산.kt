package 백준

import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val (e,s,m)=br.readLine().split(" ").map { it.toInt()-1 }
    var i=0
    while (true){
        if(i%15==e && i%28==s && i%19 ==m){
            println(i+1)
            exitProcess(0)
        }
        i++
    }
}