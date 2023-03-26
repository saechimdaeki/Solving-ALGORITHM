package boj2230

fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = IntArray(n)
    repeat(n.toInt()) {
        arr[it] = readLine()!!.toInt()
    }
    arr.sort()
    var answer = arr.last() - arr.first()
    var left = 0
    var right = 1
    while (left < n && right < n) {
        val diff = arr[right] - arr[left]
        if (diff >= m) {
            answer = minOf(answer, diff)
            left++
        } else {
            right++
        }
    }
    println(answer)
}