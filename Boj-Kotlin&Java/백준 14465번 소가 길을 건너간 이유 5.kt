package 백준

import kotlin.math.min

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k,b)=br.readLine().split(" ").map { it.toInt() }
    val arr=IntArray(n+2){it}
    repeat(b){
        arr[br.readLine().toInt()]=0
    }
    var sum=0
    var left=1
    var right=k
    for(i in 1..right){
        if(arr[i]==0)
            sum++
    }
    var mini=sum
    for(i in right..n){
        right++
        if(arr[right]==0)
            sum++
        if(arr[left]==0)
            sum--
        left++
        mini= min(sum, mini)
    }
    print("${mini}")
}