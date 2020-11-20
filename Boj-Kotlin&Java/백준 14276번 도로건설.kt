package 백준

private val dp=Array(30){Array(31){Array(9){LongArray(1 shl 9){-1} }}}
private const val ggyu=1000000007L
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    println("${dfs(0,0,0,0,n,m,k)}")
}
private fun dfs(idx:Int,roadcnt:Int,current:Int,state:Int,n1:Int,m1:Int,k1:Int):Long{
    when {
        idx==n1 -> {
            return when {
                roadcnt==m1 && current==0 && state==0 -> 1
                else -> 0
            }
        }
        current==k1 -> {
            return when {
                state and (1 shl k1)==0 -> {
                    dfs(idx+1,roadcnt,0,(state shl 1),n1,m1,k1)
                }
                else -> 0
            }
        }
        else -> {
            var tmp = dp[idx][roadcnt][current][state]
            return when {
                tmp != -1L -> tmp
                else -> {
                    tmp = dfs(idx, roadcnt, current + 1, state, n1, m1, k1)
                    when {
                        idx - (current + 1) >= 0 && roadcnt + 1 <= m1 -> {
                            tmp += dfs(idx, roadcnt + 1, current, (state xor (1 shl 0) xor (1 shl (current + 1))), n1, m1, k1)
                        }
                    }
                    tmp %= ggyu
                    dp[idx][roadcnt][current][state] = tmp
                    tmp
                }
            }
        }
    }
}