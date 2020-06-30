package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

private var n=0
private var m=0
private var arr=Array<Int>(10){0}
fun main()= with(BufferedReader(InputStreamReader(System.`in`)))
{
    val input=readLine().split(" ")
     n =input[0].toInt()
     m=input[1].toInt()
    recursive(1,0)
}
private fun recursive(index:Int, start:Int)
{
    if(start==m){
        for(i in 0 until m)
        {
            print("${arr[i]} ")
        }
        println()
        return
    }
    if(index>n)
        return
    arr[start]=index
    recursive(index+1,start+1)
    arr[start]=0
    recursive(index+1,start)
}