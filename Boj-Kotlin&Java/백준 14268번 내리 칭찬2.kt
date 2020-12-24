package 백준

import kotlin.math.ceil
import kotlin.math.ln

private lateinit var tree:IntArray
private lateinit var lazy:IntArray
private lateinit var inr:IntArray
private lateinit var outr:IntArray
private lateinit var arr:Array<ArrayList<Int>>
private var t=0
private fun dfs(x:Int){
    inr[x]=++t
    arr[x].forEach { i ->
        dfs(i)
    }
    outr[x]=++t
}
/* 문제 중간의 테스트케이스 입력조건 오류가 있는 문제임. */
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var line = br.readLine().split(" ".toRegex()).toTypedArray()
    val (n,m)= arrayOf(line[0].toInt(),line[1].toInt())
    arr=Array(n+1){ arrayListOf()}
    inr= IntArray(n+1)
    outr= IntArray(n+1)
    line = br.readLine().split(" ".toRegex()).toTypedArray()
    for(i in 1..n){
        val p=line[i-1].toInt()
        if(p==-1) continue
        arr[p].add(i)
    }
    dfs(1)
    val h= ceil(ln(t.toDouble())/ln(2.0)).toInt()
    val size=(1 shl (h+1))
    tree= IntArray(size)
    lazy= IntArray(size)
    repeat(m){
        line = br.readLine().split(" ".toRegex()).toTypedArray()
        when (line[0].toInt()) {
            1 -> {
                val index = line[1].toInt()
                val `val` = line[2].toInt()
                updateRange(tree, lazy, 1, 1, t, inr[index], outr[index], `val`)
            }
            2 -> {
                val index = line[1].toInt()
                bw.write("${query(tree, lazy, 1, 1, t, inr[index])}".trimIndent())
                bw.write("\n")
            }
        }
    }
    bw.flush()
}

private fun updateLazy(tree: IntArray, lazy: IntArray, node: Int, start: Int, end: Int) {
    when {
        lazy[node] != 0 -> {
            tree[node] += (end - start + 1) * lazy[node]
            when {
                start != end -> {
                    lazy[node * 2] += lazy[node]
                    lazy[node * 2 + 1] += lazy[node]
                }
            }
            lazy[node] = 0
        }
    }
}

private fun updateRange(tree: IntArray, lazy: IntArray, node: Int, start: Int, end: Int, left: Int, right: Int, diff: Int) {
    updateLazy(tree, lazy, node, start, end)
    when {
        left > end || right < start -> {
            return
        }
        left <= start && end <= right -> {
            tree[node] += (end - start + 1) * diff
            when {
                start != end -> {
                    lazy[node * 2] += diff
                    lazy[node * 2 + 1] += diff
                }
            }
            return
        }
        else -> {
            updateRange(tree, lazy, node * 2, start, (start + end) / 2, left, right, diff)
            updateRange(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right, diff)
            tree[node] = tree[node * 2] + tree[node * 2 + 1]
        }
    }
}

private fun query(tree: IntArray, lazy: IntArray, node: Int, start: Int, end: Int, index: Int): Int {
    updateLazy(tree, lazy, node, start, end)
    when {
        index > end || index < start -> {
            return 0
        }
        start == end && start == index -> {
            return tree[node]
        }
        else -> {
            val mid = (start + end) / 2
            return when {
                index <= mid -> {
                    query(tree, lazy, node * 2, start, mid, index)
                }
                else -> {
                    query(tree, lazy, node * 2 + 1, mid + 1, end, index)
                }
            }
        }
    }
}