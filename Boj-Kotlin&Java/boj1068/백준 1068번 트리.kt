package boj1068

lateinit var parent : IntArray
lateinit var tree : Array<MutableList<Int>>
var answer = 0
lateinit var visited: BooleanArray
fun main() {
    val n = readLine()!!.toInt()
    var rootNode = 0
    val input = readLine()!!.split(" ").map { it.toInt() }
    parent = IntArray(n)
    tree = Array(n) { mutableListOf() }
    visited = BooleanArray(n)
    for (i in input.indices) {
        if(input[i]==-1) {
            rootNode=i
            continue
        }
            tree[i].add(input[i])
            tree[input[i]].add(i)
    }
    val remove = readLine()!!.toInt()
    if(remove == rootNode) {
        println(0)
        return
    }
    dfs(rootNode,remove)
    println(answer)
}

fun dfs(rootNode: Int, removeNode: Int) {
    visited[rootNode] = true
    var cnt = 0
    (0 until tree[rootNode].size).forEach { i ->
        val next = tree[rootNode][i]
        if ( !visited[next] && next != removeNode) {
            cnt++
            dfs(next, removeNode)
        }
    }
    if (cnt == 0) answer++
}