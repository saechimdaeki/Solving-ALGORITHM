package boj14681kot

import java.util.*


var myGraph: Array<IntArray> = arrayOf()
var myVisited: BooleanArray = booleanArrayOf()

fun main() {

    val (a, b, c) = readLine()!!.split(' ').map(String::toInt)

    myGraph = Array(a + 1) { IntArray(a + 1) }
    myVisited = BooleanArray(a + 1)

    for (i in 0 until b) {
        val (n, m) = readLine()!!.split(' ').map(String::toInt)
        myGraph[n][m] = 1
        myGraph[m][n] = 1
    }

    dfs1(c)

    for (i in myVisited.indices) {
        myVisited[i] = false
    }
    println()
    bfs1(c)
}

private fun dfs1(n: Int) {
    myVisited[n] = true
    print("$n ")

    for (i in 1 until myGraph.lastIndex+1) {
        if (myGraph[n][i] == 1 && !myVisited[i]) {
            dfs1(i)
        }
    }
}

private fun bfs1(n: Int) {

    var queue: Queue<Int> = LinkedList<Int>()
    queue.add(n)
    myVisited[n] = true
    print("$n ")

    while (!queue.isEmpty()) {
        var d = queue.poll()
        for (i in 1 until myGraph.lastIndex+1) {
            if (myGraph[d][i] == 1 && !myVisited[i]) {
                queue.add(i)
                myVisited[i] = true
                print("$i ")
            }
        }
    }

}