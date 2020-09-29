package 백준
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp=IntArray(n+1)
    for(i in 0 until n){
        dp[i]=1
        for(j in 0 until i){
            if(arr[j]<arr[i] && dp[i]<dp[j]+1)
                dp[i]=dp[j]+1
        }
    }
    println(dp.max())
}
