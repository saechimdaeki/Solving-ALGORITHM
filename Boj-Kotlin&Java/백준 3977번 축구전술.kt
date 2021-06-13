import java.util.*

var arr = Array(100001) { ArrayList<Int>() }
var ar = Array(100001) { ArrayList<Int>() }
var component = IntArray(100001)
var c = BooleanArray(100000)
var order = arrayListOf<Int>()
fun dfs(x: Int) {
    if (c[x]) return
    c[x] = true
    arr[x].indices.forEach { i ->
        dfs(arr[x][i])
    }
    order.add(x)
}

fun dfs_rev(x: Int, cn: Int) {
    if (c[x]) return
    c[x] = true
    component[x] = cn
    ar[x].indices.forEach { i ->
        dfs_rev(ar[x][i], cn)
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    var t = sc.nextInt()
    while (t-- > 0) {
        val n = sc.nextInt()
        var m = sc.nextInt()
        (0 until n).forEach { i ->
            arr[i] = ArrayList()
            ar[i] = ArrayList()
            component[i] = 0
            c[i] = false
        }
        order = ArrayList()
        while (m-- > 0) {
            val u = sc.nextInt()
            val v = sc.nextInt()
            arr[u].add(v)
            ar[v].add(u)
        }
        (0 until n)
                .asSequence()
                .filterNot { c[it] }
                .forEach { dfs(it) }

        order.reverse()
        Arrays.fill(c, false)
        var cnt = 0
        (0 until n).forEach { i ->
            if (component[order[i]] == 0) {
                cnt += 1
                dfs_rev(order[i], cnt)
            }
        }
        val indegree = IntArray(cnt + 1)
        (0 until n).forEach { i ->
            arr[i]
                    .asSequence()
                    .filter { component[i] != component[it] }
                    .forEach { indegree[component[it]] += 1 }
        }
        var zero = 0
        (1..cnt)
                .asSequence()
                .filter { indegree[it] == 0 }
                .forEach { zero += 1 }

        if (zero == 1) {
            (1..cnt).forEach { i ->
                if (indegree[i] == 0) {
                    (0 until n)
                            .asSequence()
                            .filter { component[it] == i }
                            .forEach { println(it) }
                }
            }
        } else {
            println("Confused")
        }
        println()
    }
}
