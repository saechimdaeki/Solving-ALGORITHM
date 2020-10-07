package 백준

import java.util.*

fun main() {
    //val br=System.`in`.bufferedReader()
   // val bw=System.out.bufferedWriter()
    val sc=Scanner(System.`in`)
    while (sc.hasNext()){
        val n=sc.nextInt()
        val arr=IntArray(n+1)
        for(i in 0 until n){
            arr[i]=sc.nextInt()
        }
        val dp=IntArray(n+1)
        dp[0]=arr[0]
        var idx=0
        for(i in 1 until n){
            if(dp[idx]<arr[i]){
                dp[++idx]=arr[i]
            }else{
                val loc= lower_bound(dp,arr[i],idx)
                dp[loc]=arr[i]
            }
        }
        println("${idx+1}")
       // bw.write("${idx+1}\n")
    }
  //  bw.flush()
}
private fun lower_bound(a:IntArray,key:Int,idx:Int):Int{
    var left=0
    var right=idx+1
    while (left<right){
        val mid=(left+right)/2
        if(a[mid]<key){
            left=mid+1
        }else
            right=mid
    }
    return left
}