package 백준

import java.util.*
/* 문제 입력 TC인풋에 불필요한 공백이 있는문제라서 StringTokenizer 사용해야함... 현재 수정 건의중*/
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=IntArray(n+1)
    val dp=IntArray(n+1)
    val st=StringTokenizer(br.readLine())
    for(i in 0 until n){
        arr[i]=st.nextToken().toInt()
    }
    var idx=0
    var answer=0
    dp[0]=arr[0]
    for(i in 1 until n ){
        if(dp[idx]<arr[i]){
            dp[++idx]=arr[i]
        }else{
            val loc= lower_bound(dp,arr[i],idx)
            dp[loc]=arr[i]
            answer++
        }
    }
    println("$answer")
}
private fun lower_bound(a:IntArray,key:Int,idx:Int):Int{
    var left=0
    var right=idx
    while (left<right){
        val mid=(left+right)/2
        if(a[mid]<key){
            left=mid+1
        }else
            right=mid
    }
    return left
}