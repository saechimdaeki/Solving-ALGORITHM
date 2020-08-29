package 백준

private lateinit var arr:IntArray
private lateinit var dp:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    arr= IntArray(n)
    dp= IntArray(k+1){-1}
    for(i in 0 until n)
        arr[i]=br.readLine().toInt()
    dp[0]=0
    for(i in 0 until n){
        for(j in 0 ..k){
            if(j- arr[i]>=0 && dp[j-arr[i]]!=-1){
                if(dp[j]==-1 || dp[j]>dp[j-arr[i]]+1){
                    dp[j]=dp[j-arr[i]]+1
                }
            }
        }
    }
    println(dp[k])
}