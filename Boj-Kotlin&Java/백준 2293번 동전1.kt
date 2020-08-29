package 백준

private lateinit var arr:IntArray
private lateinit var dp:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    arr= IntArray(n)
    dp= IntArray(100001)
    for(i in 0 until n){
        arr[i]=br.readLine().toInt()
    }
    dp[0]=1
    for(i in 0 until n){
       for(j in arr[i] .. k){
           dp[j]+=dp[j-arr[i]]
       }
    }
    println(dp[k])
}