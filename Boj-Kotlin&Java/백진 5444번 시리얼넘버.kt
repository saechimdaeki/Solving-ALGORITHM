package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val (n,m)=br.readLine().split(" ").map { it.toInt() }
        val arr=br.readLine().split(" ").map { it.toInt()%m }.toIntArray()
        val dp=Array(2){IntArray(100000){-1}}
        dp[0][0]=0
        (0 until n).forEach { i ->
            val (now,next)= arrayOf(i%2,(i+1)%2)
            dp[next].fill(-1)
            (0 until m).forEach { j ->
                when {
                    dp[now][j]==-1 -> return@forEach
                    dp[next][j]==-1 || dp[next][j]<dp[now][j] -> dp[next][j]=dp[now][j]
                }
                val tmp=(j+arr[i])%m
                when {
                    dp[next][tmp]==-1 || dp[next][tmp]<dp[now][j]+1 -> dp[next][tmp]=dp[now][j]+1
                }
            }
        }
        bw.write("${dp[n%2][0]}\n")
    }
    bw.flush()
}