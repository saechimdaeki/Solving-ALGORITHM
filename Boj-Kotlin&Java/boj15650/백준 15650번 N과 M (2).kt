package boj15650


val bw = System.out.bufferedWriter()
lateinit var visited: BooleanArray

fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val arr= IntArray(n){it+1}
    visited = BooleanArray(n)
    dfs(arr,m,0,IntArray(m),0)
    bw.flush()
}

fun dfs(arr: IntArray, m: Int, depth: Int, intArray: IntArray, startIdx: Int) {
    if (depth == m) {
        bw.write("${intArray.joinToString(" ")}\n")
        return
    }
    for (j in startIdx until arr.size) {
        if (!visited[j]) {
            visited[j] = true
            intArray[depth] = arr[j]
            dfs(arr, m, depth + 1, intArray,j+1)
            visited[j] = false
        }
    }
}




