package 백준

import kotlin.math.abs

private lateinit var arr:Array<Array<Int>>
private val saram= arrayListOf<Pair<Int,Int>>()
private val chicken= arrayListOf<Pair<Int,Int>>()
private lateinit var dist:IntArray
// 치킨집개수 2^13
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){Array(n){0}}
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices){
            arr[i][j]=input[j]
            if(arr[i][j]==1)
                saram.add(Pair(i,j))
            else if(arr[i][j]==2)
                chicken.add(Pair(i,j))
        }
    }
    dist= IntArray(chicken.size)
    for(i in 0 until m)
        dist[i]=1
    dist.sort()
    var answer=-1
    do{
        var sum=0
        for(i in saram){
            var min=-1
            for(j in 0 until chicken.size){
                if(dist[j]==0) continue
                val tmp= chicken[j]
                val d1= abs(i.first-tmp.first)
                val d2= abs(i.second-tmp.second)
                val di=d1+d2
                if(min==-1 || min>di)
                    min=di
            }
            sum+=min
        }
        if(answer==-1 || answer>sum)
            answer=sum
    }while (next(dist))
    println(answer)
}
private fun next(d:IntArray):Boolean{
    var i=d.size-1
    while (i>0 && d[i-1]>=d[i])
        i--
    if(i<=0)
        return false
    var j=d.size-1
    while (d[j]<=d[i-1])
        j--
    var tmp=d[i-1]
    d[i-1]=d[j]
    d[j]=tmp
    j=d.size-1
    while (i<j){
       tmp=d[i]
        d[i]=d[j]
        d[j]=tmp
        i++
        j--
    }
    return true
}