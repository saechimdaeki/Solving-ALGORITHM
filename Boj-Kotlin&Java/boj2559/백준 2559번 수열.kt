package boj2559

fun main() {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    var sum = 0
    (0 until k).forEach { sum += arr[it] }

    var left = 0
    var end = k
    var answer = sum
    while (end < n) {
        sum -= arr[left++]
        sum += arr[end++]
        answer = maxOf(sum, answer)
    }
    println(answer)
}