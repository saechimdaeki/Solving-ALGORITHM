package 백준

fun main() {
    val n= readLine()!!.toInt()
    var (start,end)= arrayOf(1,1)
    var sum=0
    var answer=1
    val arr=IntArray(n){it}
    for(i in 0 .. n){
        if(sum>=n) sum-=arr[start++]
        else sum+=arr[end++]
        if(sum==n) answer++
    }
    println(answer)
}