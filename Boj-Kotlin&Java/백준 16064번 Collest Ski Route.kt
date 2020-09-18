package 백준

import kotlin.math.min

private var mini=0
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=Array(n+1){IntArray(n+1){1000000000} }
    for(i in 1..n){
        for(j in 1..n)
            if(i==j) arr[i][j]=0
    }
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr[a][b]= min(arr[a][b],-c)
        mini= min(mini,arr[a][b])
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][j]>arr[i][k]+arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j]
                    mini= min(mini,arr[i][j])
                }
            }
        }
    }
    println("${-mini}")
}