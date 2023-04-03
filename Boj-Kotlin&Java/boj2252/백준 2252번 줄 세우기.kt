package boj2252

import java.util.LinkedList

lateinit var arr: Array<ArrayList<Int>>
lateinit var inDegree: IntArray
val bw = System.out.bufferedWriter()
fun main() {

    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(n+1){ArrayList()}
    inDegree = IntArray(n+1)

    repeat(m) {
        val (a,b) = readLine()!!.split(" ").map { it.toInt() }
        arr[a].add(b)
        inDegree[b]++
    }

    bfs(n)
    bw.flush()
}

fun bfs(n: Int)  {
    val q = LinkedList<Int>()
    for (i in 1 .. n) {
        if (inDegree[i] == 0) {
            q.add(i)
        }
    }

    while(q.isNotEmpty()) {
        val now = q.poll()
        bw.write("$now ")
        for(i in arr[now]) {
            inDegree[i]--
            if(inDegree[i] == 0) {
                q.add(i)
            }
        }
    }
}
