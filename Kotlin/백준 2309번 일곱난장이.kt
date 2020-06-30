package boj14681kot

import java.util.*
import kotlin.system.exitProcess

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var sum=0
    val arr=Array(9){0}
    for(i in 0 until 9) {
        arr[i] = br.readLine().toInt()
        sum+=arr[i]
    }
    arr.sort()
    for(i in 0 until 9)
    {
        for(j in i+1 until 9)
        {
            if((sum-arr[i]-arr[j])==100)
            {
                for(k in 0 until 9)
                {
                    if(i==k ||j==k)
                        continue
                    println(arr[k])
                }
                exitProcess(0)
            }
        }

    }
}