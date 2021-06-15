import java.util.*

private var a = Array(10001) { ArrayList<Int>() }
private val check = BooleanArray(10001)
private var low = IntArray(10001)
private var num = IntArray(10001)
private var cnt = 0
private var s = Stack<Int>()
private var ans = ArrayList<ArrayList<Int>>()

private fun dfs(x: Int) {
    check[x] = true
    s.push(x)
    num[x] = ++cnt
    low[x] = cnt
    a[x].indices
            .asSequence()
            .map { a[x][it] }
            .forEach {
                when {
                    num[it] == 0 -> {
                        dfs(it)
                        low[x] = low[x].coerceAtMost(low[it])
                    }
                    check[it] -> {
                        low[x] = low[x].coerceAtMost(num[it])
                    }
                }
            }
    if (low[x] == num[x]) {
        val scc = ArrayList<Int>()
        while (!s.isEmpty()) {
            val y = s.pop()
            scc.add(y)
            check[y] = false
            if (x == y) {
                break
            }
        }
        scc.sort()
        ans.add(scc)
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var m = sc.nextInt()
    (1..n).forEach { i ->
        a[i] = ArrayList()
    }
    while (m-- > 0) {
        val u = sc.nextInt()
        val v = sc.nextInt()
        a[u].add(v)
    }
    (1..n).forEach { i ->
        if (num[i] == 0) {
            dfs(i)
        }
    }
    Collections.sort(ans, Comparator { l1, l2 ->
        val n = l1.size
        val m = l2.size
        var i = 0
        while (i < n && i < m) {
            val t1 = l1[i]
            val t2 = l2[i]
            if (t1 < t2) return@Comparator -1 else if (t1 > t2) return@Comparator 1
            i += 1
        }
        if (i == n && i != m) return@Comparator -1 else if (i != n && i == m) return@Comparator 1
        0
    })
    println(ans.size)
    ans.forEach { scc ->
        scc.forEach { x ->
            print("$x ")
        }
        println(-1)
    }
}
