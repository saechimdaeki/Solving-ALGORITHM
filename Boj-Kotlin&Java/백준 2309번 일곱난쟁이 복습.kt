package 백준

import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val arr= arrayListOf<Int>()
    for(i in 0 until 9)
        arr.add(br.readLine().toInt())
    val sum=arr.sum()
    arr.sort()
    for(i in 0 until 9){
        for(j in i+1 until 9){
            if(sum-arr[i]-arr[j]==100){
                for(k in 0 until 9)
                {
                    if(i==k||j==k)continue
                    println("${arr[k]}")
                }
                exitProcess(0)
            }
        }
    }
}