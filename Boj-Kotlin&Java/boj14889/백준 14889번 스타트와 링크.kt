import kotlin.math.abs

var n =0
lateinit var arr:Array<IntArray>
lateinit var visited: BooleanArray
var answer = Int.MAX_VALUE

fun main() {
    n = readLine()!!.toInt()
    arr = Array(n){IntArray(n)}

    (0 until n)
        .forEach { i ->
            arr[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
        }
    visited = BooleanArray(n)

    dfs(0,0)

    println(answer)

}

fun dfs(cnt: Int, idx: Int) {
    if(cnt == n/2) {
        var start = 0
        var link = 0
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                when {
                    visited[i] && visited[j] -> start += arr[i][j]
                    !visited[i] && !visited[j] -> link += arr[i][j]
                }
            }
        }

        answer = minOf(answer, abs(link - start))
        return
    }

    (idx until n).forEach { i ->
        visited[i] = true
        dfs(cnt+1, i+1)
        visited[i] = false
    }
}