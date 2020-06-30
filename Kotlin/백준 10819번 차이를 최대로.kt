package boj14681kot

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

private var n=0
private lateinit var arr:ArrayList<Int>
private lateinit var all:ArrayList<Int>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    n=br.readLine().toInt()
    arr= ArrayList()
    all=ArrayList()
    val st=StringTokenizer(br.readLine())
    var sum=0
    for(i in 0 until n)
        arr.add(st.nextToken().toInt())
    arr.sort()
    for(i in 1 until n)
    {
        sum+= abs(arr[i]-arr[i-1])
    }
    all.add(sum)

    while(next())
    {
        sum=0
        for(i in 1 until n)
        {
            sum+= abs(arr[i]-arr[i-1])
        }
        all.add(sum)
    }
    println(all.max())

}
private fun next():Boolean{
    var i=arr.size-1
    while(i>0 && arr[i-1]>=arr[i])
        i--
    if(i<=0)
        return false
    var j=arr.size-1
    while (arr[j]<=arr[i-1])
        j--
    var tmp=arr[i-1]
    arr[i-1]=arr[j]
    arr[j]=tmp
    j=arr.size-1
    while (i<j)
    {
        tmp=arr[i]
        arr[i]=arr[j]
        arr[j]=tmp
        i++
        j--
    }
    return true
}