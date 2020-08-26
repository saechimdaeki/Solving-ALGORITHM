package boj14681kot

import kotlin.math.min

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var arr=Array(1000001) {0};
    for(i in 2..n)
    {
        arr[i]=arr[i-1]+1;
        if(i%2==0)
            arr[i]= min(arr[i],arr[i/2]+1)
        if(i%3==0)
            arr[i]=min(arr[i],arr[i/3]+1)
    }
    println(arr[n])
}