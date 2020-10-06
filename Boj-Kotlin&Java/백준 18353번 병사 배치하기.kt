package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp=IntArray(n+1)
    dp[0]=1

    (1 until arr.size).forEach { i ->
        dp[i]=1
        (0 until i)
                .asSequence()
                .filter { arr[i]<arr[it] && dp[i]<dp[it]+1 }
                .forEach { dp[i]=dp[it]+1 }
    }
    println("${n-dp.max()!!}")
}