package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`)))
{
    val input=readLine().split(" ")
    val n=input[0].toInt()
    val k=input[1].toInt()
    val mod=1000000000
    val dp=Array(201){Array(201){0} }
    dp[0][0]=1
    for(i in 1..k){
        for (j in 0..n){
            for (l in 0..j)
            {
                dp[i][j]+=dp[i-1][j-l]
                dp[i][j]%=mod
            }
        }
    }
    print(dp[k][n])
}