package boj14681kot

import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=Array(n+1){Array(n+1){0} }
    val dp=Array(n+1){Array(n+1){0} }
    for(i in 0 until n)
    {
        val st=StringTokenizer(br.readLine())
        for (j in 0 .. i){

            arr[i][j]=st.nextToken().toInt()
        }
    }
    dp[0][0]=arr[0][0]
    for(i in 1 until n){
        for(j in 0..i){
            dp[i][j]=dp[i-1][j]+arr[i][j]
            if(j-1>=0 && dp[i][j]<dp[i-1][j-1]+arr[i][j])
                dp[i][j]=dp[i-1][j-1]+arr[i][j]
        }
    }
    val list= MutableList(0){0}
   for(i in 0 until n)
       list.add(dp[n-1][i])
    print(Collections.max(list))

}