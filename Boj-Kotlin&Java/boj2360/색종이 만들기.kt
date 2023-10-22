package 코틀린.boj.boj2360

var white = 0
var blue = 0
lateinit var arr: Array<IntArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    arr = Array(n) { IntArray(n) }
    for (i in 0 until n) arr[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    dfs(0, 0, n)
    println("$white\n$blue")
}

fun dfs(x: Int, y: Int, n: Int) {
    val color = arr[x][y]
    for (i in x until x + n) {
        for (j in y until y + n) {
            if (arr[i][j] != color) {
                dfs(x + (n / 2), y, n / 2)
                dfs(x, y, n / 2)
                dfs(x, y + (n / 2), n / 2)
                dfs(x + (n / 2), y + (n / 2), n / 2)
                return
            }
        }
    }
    when (color) {
        1 -> blue++
        else -> white++
    }
}

