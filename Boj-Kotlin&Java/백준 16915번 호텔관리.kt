import java.util.*


private var num = IntArray(200000)
   private var check = BooleanArray(200000)
   private fun dfs(a: Array<ArrayList<Int>>, x: Int, s: ArrayList<Int>) {
        if (check[x]) {
            return
        }
        check[x] = true
        for (next in a[x]) {
            dfs(a, next, s)
        }
        s.add(x)
    }

   private fun dfs2(a: Array<ArrayList<Int>>, x: Int, cnt: Int) {
        if (check[x]) {
            return
        }
        check[x] = true
        num[x] = cnt
        for (next in a[x]) {
            dfs2(a, next, cnt)
        }
    }

    private fun node(x: Int, n: Int): Int {
        return when {
            x > 0 -> {
                x - 1
            }
            else -> {
                2 * n + x
            }
        }
    }

   private fun make_edge(a: Array<ArrayList<Int>>, ar: Array<ArrayList<Int>>, from: Int, to: Int, m: Int) {
        a[node(-from, m)].add(node(to, m))
        ar[node(to, m)].add(node(-from, m))
        a[node(-to, m)].add(node(from, m))
        ar[node(from, m)].add(node(-to, m))
    }


    fun main() {
        val br=System.`in`.bufferedReader()
        val (n,m)=br.readLine().split(" ").map { it.toInt() }
        val open = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        val door = Array(n) { IntArray(2) }
        (1..m).forEach { i ->
            val sc=StringTokenizer(br.readLine())
            val cnt = sc.nextToken().toInt()
            (0 until cnt).forEach { j ->
                val v = sc.nextToken().toInt()
                when {
                    door[v - 1][0] == 0 -> {
                        door[v - 1][0] = i
                    }
                    else -> {
                        door[v - 1][1] = i
                    }
                }
            }
        }
        val a=Array(2*m){ArrayList<Int>()}
        val ar=Array(2*m){ArrayList<Int>()}
        (0 until n).forEach { i ->
            val from = door[i][0]
            val to = door[i][1]
            when {
                open[i] == 1 -> {
                    make_edge(a, ar, -from, to, m)
                    make_edge(a, ar, from, -to, m)
                }
                else -> {
                    make_edge(a, ar, from, to, m)
                    make_edge(a, ar, -from, -to, m)
                }
            }
        }
        val s = ArrayList<Int>()
        (0 until 2 * m).forEach { i ->
            check[i] = false
        }
        (0 until 2 * m).forEach { i ->
            dfs(a, i, s)
        }
        (0 until 2 * m).forEach { i ->
            check[i] = false
            num[i] = 0
        }
        (2 * m - 1 downTo 0)
                .asSequence()
                .filterNot { check[s[it]] }
                .forEachIndexed { cnt, i -> dfs2(ar, s[i], cnt) }
        val ok = (0 until m).none { num[it] == num[2 * m - it - 1] }
        println(if (ok) 1 else 0)
    }
