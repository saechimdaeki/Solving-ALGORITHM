package boj7795

fun main() {
    val t = readln()!!.toInt()
    val bw = System.out.bufferedWriter()
    repeat(t) {
        val (n, m) = readln()!!.split(" ").map { it.toInt() }
        val a = readln()!!.split(" ").map { it.toInt() }.sorted()
        val b = readln()!!.split(" ").map { it.toInt() }.sorted()
        var answer = 0
        for (i in 0 until n) {
            val target = a[i]
            var left = 0
            var right = m - 1
            while (left <= right) {
                val mid = (left + right) / 2
                if (b[mid] < target) {
                    left = mid + 1
                } else if (b[mid] >= target) {
                    right = mid - 1
                }
            }
            answer += left

        }
        bw.write("$answer\n")
    }

    bw.flush()
}