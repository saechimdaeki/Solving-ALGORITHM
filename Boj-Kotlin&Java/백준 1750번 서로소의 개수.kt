package 백준
private val arr= arrayListOf<Int>()
private const val mod=10000003
private val dp=Array(101){IntArray(100001)}
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr.add(0)
    repeat(n){
        arr.add(br.readLine().toInt())
    }
    (1.. n).forEach { i ->
        dp[i][arr[i]]+=1
        (1..100000).forEach { j ->
            if(dp[i-1][j]==0) return@forEach
            dp[i][j]+=dp[i-1][j]
            dp[i][j]%=mod
            val temp=gcd(j,arr[i])
            dp[i][temp]+=dp[i-1][j]
            dp[i][temp]%=mod
        }
    }
    println("${dp[n][1]}")

}
private fun gcd(x:Int,y:Int):Int{
    return when (y) {
        0 -> x
        else -> gcd(y, x % y)
    }
}