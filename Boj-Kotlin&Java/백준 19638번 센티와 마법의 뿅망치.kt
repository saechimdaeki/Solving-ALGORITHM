package 백준

import java.util.*
import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,h,t)=br.readLine().split(" ").map { it.toInt() }
    val arr= arrayListOf<Int>()
    repeat(n){
        arr.add(br.readLine().toInt())
    }
    val pq=PriorityQueue<Int>()
    for(i in arr.indices){
        pq.offer(-arr[i])
    }
    for(i in 0 until t){
        var tmp=-pq.peek()
        if(tmp<h){
            println("YES")
            println("$i")
            exitProcess(0)
        }else if(tmp>1){
            tmp/=2
            pq.poll()
            pq.offer(-tmp)
        }
    }
    if(-pq.peek()<h){
        println("YES")
        println(t)
    }else{
        println("NO")
        println("${-pq.poll()}")
    }
}