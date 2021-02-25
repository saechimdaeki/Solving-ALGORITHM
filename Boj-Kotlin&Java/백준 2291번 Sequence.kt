val dp=Array(11){Array(221){LongArray(221) } }
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m,s)=br.readLine().split(" ").map { it.toInt() }
    (1..m).forEach { i ->
        dp[1][i][i]=1L
    }
    (2..n).forEach { i ->
        (2..m).forEach { j ->
            (1..j).forEach { k ->
                (k..j).forEach { l ->
                    when {
                        j-k>=1 -> {
                            dp[i][j][k]+=dp[i-1][j-k][l]
                        }
                    }
                }
            }
        }
    }
    dfs(n,m,1,s.toLong()-1,m)
    println()
}
fun dfs(len:Int, sum:Int, last:Int, cnt:Long,m:Int){
    if(len<=0){
        return
    }
    var acc=0L
    loop@ for(i in last ..m){
        when {
            cnt<acc+dp[len][sum][i] -> {
                print("$i ")
                dfs(len-1,sum-i,i,cnt-acc,m)
                break@loop
            }
        }
        acc+=dp[len][sum][i]
    }
}