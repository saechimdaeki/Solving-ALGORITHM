package boj14681kot

import kotlin.system.exitProcess

private val visited=Array(1500){Array(1500){false} }
private var sum=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (a,b,c) = br.readLine().split(" ").map { it->it.toInt() }
    sum=a+b+c
    if(sum%3!=0)
    {
        print(0)
        exitProcess(0)
    }
    solve(a,b)
    if(visited[sum/3][sum/3])
        println(1)
    else
        println(0)
}
private fun solve(x:Int,y:Int){
    if(visited[x][y])
        return
    visited[x][y]=true
    val arr = intArrayOf(x,y,sum-x-y)
    for(i in 0 until 3)
    {
        for(j in 0 until 3)
        {
            if(arr[i]<arr[j])
            {
                val brr= intArrayOf(x,y,sum-x-y)
                brr[i]+=arr[i]
                brr[j]-=arr[i]
                solve(brr[0],brr[1])
            }
        }
    }
}