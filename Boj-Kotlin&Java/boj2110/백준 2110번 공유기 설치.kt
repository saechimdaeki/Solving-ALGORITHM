package boj2110
lateinit var house: IntArray
var answer=0
fun main() {
    val (n, c) = readLine()!!.split(" ").map { it.toInt() }
    house = IntArray(n)
    for (i in 0 until n) {
        house[i] = readLine()!!.toInt()
    }
    house.sort()

    var left = 1
    var right = house.last()
    while (left <= right) {
        val mid = (left + right) / 2
        if (check(mid,c)) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(answer)
}

fun check(mid:Int, c: Int) : Boolean{
    var cnt = 1
    var start = house[0]
    for (i in 1 until house.size) {
        if (house[i] - start >= mid) {
            cnt++
            start = house[i]
        }
    }
    if (cnt >= c) {
        answer = mid
        return true
    }
    return false
}