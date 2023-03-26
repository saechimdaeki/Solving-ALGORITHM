package boj16472

fun main() {
    val n = readLine()!!.toInt()
    val s = readLine()!!.toCharArray()
    val cnt = IntArray(26)

    var answer = 0

    var start = 0
    var end = 0

    cnt[s[0] - 'a']++
    var count = 1
    while (end < s.size - 1) {
        end++

        val num = s[end] - 'a'
        cnt[num]++
        if (cnt[num] == 1) count++

        while (count > n) {
            val num = s[start] - 'a'
            cnt[num]--

            if (cnt[num] == 0) count--
            start++
        }
        answer = Math.max(answer, end - start + 1)
    }
    println(answer)
}