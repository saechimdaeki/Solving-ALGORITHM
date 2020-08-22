package boj14681kot

import kotlin.math.abs
import kotlin.math.min

private lateinit var arr:Array<Array<Int>>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    val b=Array(n){0}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it->it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n/2)
        b[i]=1
    b.sort()
    var answer=Int.MAX_VALUE
    do{
        val first=ArrayList<Int>()
        val second=ArrayList<Int>()
        for(i in 0 until n)
        {
            if(b[i]==0)
                first.add(i)
            else
                second.add(i)
        }
        var one=0
        var two=0
        for(i in 0 until n/2)
        {
            for(j in 0 until n/2)
            {
                if (i==j)
                    continue
                one+=arr[first[i]][first[j]]
                two+=arr[second[i]][second[j]]
            }
        }
        var ans= abs(one-two)
        answer= min(answer,ans)
    }while (next(b))
    println(answer)
}
private fun next(a:Array<Int>):Boolean{
    var i=a.size-1

    while(i>0 && a[i-1]>=a[i])
        i--
    if(i<=0)
        return false
    var j=a.size-1
    while(a[j]<=a[i-1])
        j--
    var tmp=a[i-1]
    a[i-1]=a[j]
    a[j]=tmp
    j=a.size-1
    while(i<j)
    {
        tmp=a[i]
        a[i]=a[j]
        a[j]=tmp
        i++
        j--
    }

    return true
}