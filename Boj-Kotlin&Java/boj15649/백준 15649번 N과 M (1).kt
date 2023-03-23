package boj15649

val bw= System.out.bufferedWriter()
lateinit var visited: BooleanArray
fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val arr= IntArray(n){it+1}
    visited = BooleanArray(n)
    dfs(arr,m,0,IntArray(m))
    bw.flush()
}

fun dfs(arr:IntArray, m: Int, depth: Int, intArray: IntArray){
    if(depth == m){
        bw.write("${intArray.joinToString(" ")}\n")
        return
    }
    arr.indices.forEach { i ->
        when {
            !visited[i] -> {
                visited[i] = true
                intArray[depth] = arr[i]
                dfs(arr,m,depth+1,intArray)
                visited[i] = false
            }
        }
    }
}