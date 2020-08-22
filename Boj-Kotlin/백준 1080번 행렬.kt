package boj14681kot

import kotlin.system.exitProcess

private lateinit var arr1:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it->it.toInt() }
     arr1=Array(n){Array(m){0}}
    val arr2=Array(n){Array(m){0}}
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr1[i][j]=input[j]-'0'
    }
    for(i in 0 until n)
    {
        val input=br.readLine()
        for(j in input.indices)
            arr2[i][j]=input[j]-'0'
    }
    var answer=0
    for(i in 0 until n-2)
    {
        for(j in 0 until m-2)
        {
            if(arr1[i][j]!=arr2[i][j])
            {
                answer++
                flip(i+1,j+1)
            }
        }
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
        {
            if(arr1[i][j]!=arr2[i][j])
            {
                println(-1)
                exitProcess(0)
            }
        }
    }
    println(answer)
}
private fun flip(x:Int,y:Int)
{
    for(i in x-1 ..x+1)
    {
        for(j in y-1..y+1)
            arr1[i][j]=1-arr1[i][j]
    }
}