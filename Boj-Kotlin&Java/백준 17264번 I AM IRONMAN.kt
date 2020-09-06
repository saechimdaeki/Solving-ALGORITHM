package 백준

import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,p)=br.readLine().split(" ").map { it.toInt() }
    val (w,l,g)=br.readLine().split(" ").map { it.toInt() }
    val map= mutableMapOf<String,String>()
    repeat(p){
        val (player,result)=br.readLine().split(" ")
        map[player]=result
    }
    var point=0
    repeat(n){
        val player=br.readLine()
        if(map.containsKey(player))
        {
            val result= map[player]
            when (result) {
                "W" -> point+=w
                else -> point-=l
            }
        }else{
            point-=l
        }
        if(point<0)
            point=0
        else if(point>=g){
            println("I AM NOT IRONMAN!!")
            exitProcess(0)
        }
    }
    println("I AM IRONMAN!!")
}