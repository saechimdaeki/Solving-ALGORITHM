package boj1654

lateinit var lines : LongArray
var answer = 0L
fun main() {
    val (k,n) = readLine()!!.split(" ").map { it.toLong() }
    lines = LongArray(k.toInt())
    repeat(k.toInt()) {
        lines[it] = readLine()!!.toLong()
    }

    lines.sort()

    var left = 1L
    var right = lines.last()

    while (left<=right) {
        val mid = (left+right)/2
        if(possible(mid, n)) {
            answer = maxOf(answer, mid)
            left = mid + 1
        }else {
            right = mid -1
        }
    }

    println(answer)
}

fun possible(mid: Long, n: Long) : Boolean {
    var sum = 0L
    for(i in lines.indices) {
        sum += lines[i]/mid
    }
    return sum >= n
}