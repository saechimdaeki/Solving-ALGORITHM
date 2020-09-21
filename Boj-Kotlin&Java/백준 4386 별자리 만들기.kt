package 백준

import kotlin.math.sqrt

private lateinit var parent:IntArray
private val doublecal= arrayListOf<Pair<Double,Double>>()
private val list= arrayListOf<Triple<Int,Int,Double>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    parent= IntArray(n+1){it}
    repeat(n){
        val input=br.readLine().split(" ").map { it.toDouble() }
        doublecal.add(Pair(input[0],input[1]))
    }
    for(i in doublecal.indices){
        val x= doublecal[i].first
        val y= doublecal[i].second
        for(j in i+1 until doublecal.size){
            val x2= doublecal[j].first
            val y2= doublecal[j].second
            list.add(Triple(i,j,calc(x,y,x2,y2)))
        }
    }
    list.sortBy { it.third }
    var answer:Double= 0.0
    for(i in list.indices){
        if(find(list[i].first)!= find(list[i].second)){
            answer+=list[i].third
            union(list[i].first,list[i].second)
        }
    }
    val tmp=answer.toString()
    var cnt=0
    var check=false
    for(i in tmp.indices){
        if(tmp[i]=='.'){
            check=true
        }
        if(check)
            cnt++
        print("${tmp[i]}")
        if(cnt==3)
            break
    }
}
private fun find(x:Int):Int{
    if(x== parent[x])
        return x
    parent[x]= find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x), find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}
private fun calc(x1:Double,y1:Double,x2:Double,y2:Double):Double{
    return sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2))
}