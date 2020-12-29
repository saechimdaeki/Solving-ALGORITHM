package 백준

import kotlin.math.ceil
import kotlin.math.ln

private lateinit var tree:IntArray
private lateinit var lazy:IntArray
private lateinit var inr:IntArray
private lateinit var outr:IntArray
private lateinit var arr:Array<ArrayList<Int>>
private var t=0
private fun dfs(x: Int){
    inr[x]=++t
    arr[x].forEach { y ->
        dfs(y)
    }
    outr[x]=++t
}
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    arr=Array(n + 1){ arrayListOf()}
    inr= IntArray(n + 1)
    outr= IntArray(n + 1)
    val line = br.readLine().split(" ").map { it.toInt() }
    for(i in 1..n){
        val p=line[i - 1]
        if(p==-1) continue
        arr[p].add(i)
    }
    dfs(1)
    val h= ceil(ln(t.toDouble()) / ln(2.0)).toInt()
    val size=(1 shl (h+1))
    tree= IntArray(size)
    lazy= IntArray(size)
    repeat(m) {
        val temp=br.readLine().split(" ").map { it.toInt() }
        val what = temp[0]
        if (what == 1) {
            val index = temp[1]
            val index2 = temp[2]
            updateRange(tree, lazy, 1, 1, t, inr[index], inr[index], index2)
        } else if (what == 2) {
            val index = temp[1]
            bw.write("${sum(tree,lazy,1,1,t,inr[index], outr[index])}\n")
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

private fun sum(tree: IntArray, lazy: IntArray, node: Int, start: Int, end: Int, left: Int, right: Int): Int {
    updateLazy(tree, lazy, node, start, end)
    return when {
        left > end || right < start -> {
            0
        }
        else -> when {
            left <= start && end <= right -> {
                tree[node]
            }
            else -> sum(tree, lazy, node * 2, start, (start + end) / 2, left, right) + sum(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right)
        }
    }
}

