package 백준

import kotlin.math.max

private lateinit var arr:Array<Array<Char>>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){' '}}
    for(i in 0 until n){
        val input=br.readLine()
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    var answer=0
    for(i in 0 until n){
        for(j in 0 until n){
            if(j+1<n){
                var tmp=arr[i][j]
                arr[i][j]=arr[i][j+1]
                arr[i][j+1]=tmp
                val temp= check(arr)
                if(answer<temp)
                    answer=temp
                tmp=arr[i][j]
                arr[i][j]=arr[i][j+1]
                arr[i][j+1]=tmp
            }
            if(i+1<n){
                var tmp=arr[i][j]
                arr[i][j]=arr[i+1][j]
                arr[i+1][j]=tmp
                val temp= check(arr)
                if(answer<temp)
                    answer=temp
                tmp=arr[i][j]
                arr[i][j]=arr[i+1][j]
                arr[i+1][j]=tmp
            }
        }
    }
    println(answer)
}
private fun check(a:Array<Array<Char>>):Int{
    val n=a.size
    var answer=1
    for(i in 0 until n){
        var cnt=1
        for(j in 1 until n){
            if(a[i][j]==a[i][j-1])
                cnt++
            else
                cnt=1
            answer= max(answer,cnt)
        }
        cnt=1
        for(j in 1 until n){
            if(a[j][i]==a[j-1][i])
                cnt++
            else
                cnt=1
            answer= max(answer,cnt)
        }
    }
    return answer
}