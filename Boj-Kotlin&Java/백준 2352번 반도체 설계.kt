package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp=IntArray(n+1)
    dp[0]=arr[0]
    var idx=0
    (1 until n).forEach { i ->
        if(dp[idx]<arr[i]){
            dp[++idx]=arr[i]
        }else{
            val loc= lower_bound(dp,arr[i],idx)
            dp[loc]=arr[i]
        }
    }
    println(idx+1)
}
private fun lower_bound(a: IntArray, `val`: Int,idx:Int): Int {
    var left = 0
    var right = idx+1
    while (left < right) {
        val mid = (left + right) / 2
        if (a[mid] >= `val`) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}