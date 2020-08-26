package boj14681kot

import java.util.*

private lateinit var arr:Array<Int>
private var n=0
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    val st=StringTokenizer(br.readLine())
    arr=Array(n){0}
    for(i in 0 until n)
        arr[i]=st.nextToken().toInt()
    if(previous())
    {
        for(i in 0 until n)
            print("${arr[i]} ")
        println()
    }else
        println(-1)
}
private fun previous():Boolean{
    var i =arr.size-1
    while(i>0 && arr[i-1]<=arr[i])
        i--
    if(i<=0)
        return false
    var j= arr.size-1
    while(arr[j]>=arr[i-1])
        j--
    var tmp=arr[i-1]
    arr[i-1]=arr[j]
    arr[j]=tmp
    j= arr.size-1
    while(i<j)
    {
        tmp=arr[i]
        arr[i]=arr[j]
        arr[j]=tmp
        i++
        j--
    }
    return true
}