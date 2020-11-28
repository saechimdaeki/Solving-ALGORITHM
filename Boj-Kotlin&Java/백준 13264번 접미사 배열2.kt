package 백준


internal class Suffix {
    var index = 0
    var rank: IntArray = IntArray(2)

}

private fun radix_sort(len: Int, sa: IntArray, group: IntArray) {
    val n = sa.size
    val a = Array(n) { Suffix() }
    for (i in 0 until n) {
        a[i] = Suffix()
        a[i].index = sa[i]
        a[i].rank[0] = group[sa[i]]
        when {
            sa[i] + len < n -> {
                a[i].rank[1] = group[sa[i] + len]
            }
            else -> {
                a[i].rank[1] = -1
            }
        }
    }
    val temp = Array(n) { Suffix() }
    for (p in 1 downTo 0) {
        val l = maxOf(26, n)
        val cnt = IntArray(l + 1)
        val sum = IntArray(l + 2)
        for (i in 0 until n) {
            cnt[a[i].rank[p] + 1] += 1
        }
        for (i in 1 until l + 1) {
            sum[i] = sum[i - 1] + cnt[i - 1]
        }
        for (i in 0 until n) {
            temp[sum[a[i].rank[p] + 1]++] = a[i]
        }
        for (i in 0 until n) {
            a[i] = temp[i]
        }
    }
    for (i in 0 until n) {
        sa[i] = a[i].index
    }
    group[a[0].index] = 0
    for (i in 1 until n) {
        when {
            a[i].rank[0] == a[i - 1].rank[0] && a[i].rank[1] == a[i - 1].rank[1] -> {
                group[a[i].index] = group[a[i - 1].index]
            }
            else -> {
                group[a[i].index] = group[a[i - 1].index] + 1
            }
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val s = br.readLine()
    val n = s.length
    val sa = IntArray(n) { it }
    val group = IntArray(n)
    for (i in 0 until n) {
        group[i] = s[i] - 'a'
    }
    var len = 1
    while (len / 2 < n) {
        radix_sort(len, sa, group)
        len *= 2
    }
    for (i in 0 until n)
        println(sa[i])
}
