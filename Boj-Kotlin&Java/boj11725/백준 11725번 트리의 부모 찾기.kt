package boj11725

lateinit var arr : Array<ArrayList<Int>>
lateinit var parent : IntArray
fun main() {
    val n = readLine()!!.toInt()
    arr = Array(n) { ArrayList() }
    parent = IntArray(n+1)
    repeat(n-1) {
        val (a,b) = readLine()!!.split(" ").map { it.toInt() }
        arr[a-1].add(b-1)
        arr[b-1].add(a-1)
    }

    dfs(0,-1)
    for(i in 1 until n) {
        println(parent[i]+1)
    }
}

fun dfs(x:Int, par: Int) {
    for(i in arr[x]) {
        if( i==par) continue
        parent[i] = x
        dfs(i,x)
    }
}