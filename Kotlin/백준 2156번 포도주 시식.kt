package boj14681kot

import java.util.*
import kotlin.math.max

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n+1){0}
    val dp=Array(n+1){0}
    for(i in 1 .. n)
        arr[i]=br.readLine().toInt()
    dp[1]=arr[1]
    if(n>=2)
    dp[2]=arr[1]+arr[2]
    for(i in 3..n){
        dp[i]=dp[i-1]
        dp[i]= max(dp[i],dp[i-2]+arr[i])
        dp[i]=max(dp[i],dp[i-3]+arr[i-1]+arr[i])
    }
    var list= MutableList(0) {0}
    for (i in dp)
        list.add(i)
    print(Collections.max(list))



}


