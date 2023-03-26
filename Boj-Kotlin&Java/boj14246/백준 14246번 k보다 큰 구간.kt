package boj14246

import java.util.StringTokenizer

fun main() {
    val n = readLine()!!.toInt()
    val arr = IntArray(n)
    val st= StringTokenizer(readLine())
    for(i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }
    val k = readLine()!!.toInt()

    var answer = 0L
    var start = 0

    while (start < n) {
        var end = start
        var sum = 0L
        while (end <n) {
            sum += arr[end]
            if (sum >k) {
                answer++
            }
            end++
        }
        start++
    }
    println(answer)
}