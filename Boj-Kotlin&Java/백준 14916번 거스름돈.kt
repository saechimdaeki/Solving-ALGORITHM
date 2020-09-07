package 백준

import kotlin.system.exitProcess

fun main() {
    var n= readLine()!!.toInt()
    var answer=0
    if(n%5==0)
        println(n/5)
    else{
        while (true){
            if(n<0){
                println(-1)
                exitProcess(0)
            }
            if(n==0){
                println(answer)
                exitProcess(0)
            }
            n-=2
            answer++
            if(n%5==0){
                answer+=n/5
                println(answer)
                exitProcess(0)
            }
        }
    }
}