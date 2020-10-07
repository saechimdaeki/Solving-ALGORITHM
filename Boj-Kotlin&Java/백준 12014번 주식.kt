package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    var count=0
    repeat(t){
        ++count
        val (n,k)=br.readLine().split(" ").map { it.toInt() }
        val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        val dp=IntArray(n+1)
        var idx=0
        with(bw) {
            (0 until n).forEach { i ->
                val loc= lower_bound(dp,arr[i],idx)
                dp[loc]=arr[i]
                if(loc==idx+1) idx++
            }
            write("Case #$count\n")
            write(if(idx>=k) "1\n" else "0\n")
        }
    }
    bw.flush()
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

