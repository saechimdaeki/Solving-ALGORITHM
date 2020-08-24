import java.util.*
import kotlin.collections.HashMap

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val a = IntArray(n)
    for (i in 0 until n) {
        a[i] = sc.nextInt()
    }
    val s = IntArray(n + 1)
    for (i in 1..n) {
        s[i] = s[i - 1] + a[i-1]
    }
    val cnt = HashMap<Int, Int>()
    cnt[0] = 1
    var ans: Long = 0
    for (i in 1..n) {
        ans += cnt.getOrDefault(s[i] - m, 0)
        cnt[s[i]] = cnt.getOrDefault(s[i], 0) + 1
    }
    println(ans)
}
