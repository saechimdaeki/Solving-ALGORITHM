package 백준

import kotlin.math.min

fun main() {
    val br= System.`in`.bufferedReader()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        val list= arrayListOf<Pair<Int,Int>>()
        for(i in 0 until n){
            val (a,b)=br.readLine().split(" ").map { it.toInt() }
            list.add(Pair(a,b))
        }
        list.sortBy { it.first }
        var cnt=n
        var comp=list[0].second
        for(i in 1 until n){
            if(list[i].second>comp)
                cnt--
            comp= min(comp,list[i].second)
        }
        println(cnt)
    }
}