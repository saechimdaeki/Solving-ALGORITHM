package boj14681kot

fun main(args:Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    while (true) {
        val (n, m) = br.readLine().split(" ").map { it -> it.toInt() }
        if (n == 0 && m == 0)
            break
        val arr: Array<Pair<Int, Int>> = Array(10001) { Pair(it, 0) }
        for (i in 0 until n) {
            val input = br.readLine().split(" ").map { it -> it.toInt() }
            for (j in input) {
                arr[j] = arr[j].copy(first = j, second = arr[j].second + 1)
            }
        }
        arr.sortByDescending { it -> it.second }
        var second = arr[0].second
        for (i in arr) {
            if (second > i.second) {
                second = i.second
                break
            }
        }
        for (i in arr) {
            if(i.first>0)
                if (i.second == second)
                    bw.write("${i.first} ")
        }
        bw.write("\n")
    }
    bw.flush()
}