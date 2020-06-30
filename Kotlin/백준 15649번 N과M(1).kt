package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

private var n=0
private var m=0
private lateinit var arr:ArrayList<Any>
private var checked=Array<Boolean>(10){false}
fun main()= with(BufferedReader(InputStreamReader(System.`in`)))
{
    val input=readLine().split(" ")
    n=input[0].toInt()
    m=input[1].toInt()
    arr= ArrayList()
    for(i in 1..n)
        arr.add(i)
    recursive(0)
}
fun recursive(index:Int){
    if(index==m)
    {
        for(i in 0 until m)
            print("${arr[i]} ")
        println()
        return
    }
    for(i in 0 until n)
    {
        if(checked[i])
            continue
        checked[i]=true
        arr[index]=i+1
        recursive(index+1)
        checked[i]=false
    }
}