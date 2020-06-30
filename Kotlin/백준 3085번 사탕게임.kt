package boj14681kot

import kotlin.math.max

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n){CharArray(n){' '} }
    for (i in 0 until n)
    {
        arr[i]=br.readLine().toCharArray()
    }
    var ans=0
    for(i in 0 until n)
    {
        for(j in 0 until n)
        {
            if(j+1<n)
            {
                var t=arr[i][j]
                arr[i][j]=arr[i][j+1]
                arr[i][j+1]=t
                var tmp= check(arr)
                ans= max(ans,tmp)
                t=arr[i][j]
                arr[i][j]=arr[i][j+1]
                arr[i][j+1]=t
            }
            if(i+1<n)
            {
                var t=arr[i][j]
                arr[i][j]=arr[i+1][j]
                arr[i+1][j]=t
                var tmp=check(arr)
                ans=max(ans,tmp)
                t=arr[i][j]
                arr[i][j]=arr[i+1][j]
                arr[i+1][j]=t
            }
        }
    }
    println(ans)
}
fun check(x: Array<CharArray>):Int{
    val n=x.size
    var ans=1
    for(i in 0 until n)
    {
        var cnt=1
        for(j in 1 until n)
        {
            if(x[i][j]==x[i][j-1]){
                cnt++
            }else
                cnt=1
            ans= max(ans,cnt)
        }
        cnt=1
        for(j in 1 until n)
        {
            if(x[j][i]==x[j-1][i])
                cnt++
            else
                cnt=1
            ans= max(ans,cnt)
        }
    }
    return ans
}