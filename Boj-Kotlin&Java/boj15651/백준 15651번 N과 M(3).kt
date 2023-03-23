package boj15651


private val bw=System.out.bufferedWriter()
fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val arr = IntArray(n) { it + 1 }

    dfs(arr,m,0,IntArray(m))

    bw.flush()
}

fun dfs(arr:IntArray , m: Int, depth: Int, intArray: IntArray) {
    if(depth == m) {
        bw.write("${intArray.joinToString(" ")}\n")
        return
    }
    for(i in arr.indices) {
        intArray[depth] = arr[i]
        dfs(arr, m, depth + 1, intArray)
    }
}

