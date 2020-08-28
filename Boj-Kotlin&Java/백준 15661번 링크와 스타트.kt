package 백준

import kotlin.math.abs

private lateinit var arr:Array<Array<Int>>
private val firstTeam= arrayListOf<Int>()
private val secondTeam= arrayListOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices){
            arr[i][j]=input[j]
        }
    }
    println("${dfs(0, firstTeam, secondTeam,n)}")
}
private fun dfs(idx:Int,first:ArrayList<Int>,second:ArrayList<Int>,n:Int):Int{
    if(idx==n){
        if(first.size==0) return -1
        if(second.size==0) return -1
        var (t1,t2)= intArrayOf(0,0)
        for(i in 0 until first.size){
            for(j in 0 until first.size){
                if(i==j) continue
                t1+=arr[first[i]][first[j]]
            }
        }
        for(i in 0 until second.size){
            for(j in 0 until second.size){
                if(i==j) continue
                t2+=arr[second[i]][second[j]]
            }
        }
        return abs(t1-t2)
    }
    var answer=-1
    first.add(idx)
    var t1=dfs(idx+1,first,second,n)
    if(answer==-1||(t1!=-1&&answer>t1))
        answer=t1
    first.removeAt(first.size-1)
    second.add(idx)
    var t2=dfs(idx+1,first,second,n)
    if(answer==-1 ||(t2!=-1 && answer>t2))
        answer=t2
    second.removeAt(second.size-1)
    return answer
}