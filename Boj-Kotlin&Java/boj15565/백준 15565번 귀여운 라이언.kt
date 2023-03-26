package boj15565

import kotlin.math.min

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }
    // 라이언은 1 어피치는 2
    var answer = Int.MAX_VALUE

    var left = 0
    var right = 0
    var cnt = 0

    while (right <= n && left <= right) {
        if (cnt >= k) {
            answer = min(answer, right - left)
            if (arr[left] == 1) cnt--
            left++
        } else {
            if (right == n) break
            if (arr[right] == 1) cnt++
            right++
        }
    }
    println(if (answer == Int.MAX_VALUE) -1 else answer)
}