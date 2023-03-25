package boj2512

fun main() {
    val n = readLine()!!.toInt()
    val budget = readLine()!!.split(" ").map { it.toLong() }.sorted().toLongArray()
    val m = readLine()!!.toLong()

    var left = 0L
    var right = budget.last()
    var answer = 0L
    while (left<=right) {
        val mid = (left+right)/2
        var sum = 0L

        for (i in budget.indices) {
            sum += if (budget[i] > mid) {
                mid
            } else {
                budget[i]
            }
        }
        if(sum <=m) {
            answer = mid
            left = mid+1
        } else {
            right = mid-1
        }
    }
    println(answer)
}