package boj25916

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    var answer = 0
    var start = 0
    var end = 0
    var sum = 0

    while (end < n) {
        if (sum + arr[end] <= m) {
            sum += arr[end++]
            answer = maxOf(answer, sum)
        }else {
            sum -=arr[start++]
        }
    }
    println(answer)
}