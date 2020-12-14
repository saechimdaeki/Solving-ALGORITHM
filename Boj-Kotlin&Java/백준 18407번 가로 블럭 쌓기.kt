package 백준

import kotlin.math.ceil
import kotlin.math.ln

private lateinit var left:IntArray
private lateinit var right:IntArray
private lateinit var tree:IntArray
private lateinit var lazy:IntArray
private val set= mutableSetOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    left= IntArray(n)
    right= IntArray(n)
    (0 until n).forEach { i ->
        val (a1,a2)=br.readLine().split(" ").map { it.toInt() }
        left[i]=a2
        right[i]=a1+a2-1
        set.add(left[i])
        set.add(right[i])
    }
    val arr= ArrayList<Int>(set)
    arr.sort()
    val map= mutableMapOf<Int,Int>()
    for(i in arr.indices) map[arr[i]]=i

    (0 until n).forEach { i ->
        left[i]=map[left[i]]!!
        right[i]=map[right[i]]!!
    }
    val h= ceil(ln(map.size.toDouble())/ln(2.0)).toInt()
    val size=(1 shl (h+1))
    tree= IntArray(size)
    lazy= IntArray(size)
    (0 until n).forEach { i ->
        val temp= query(tree, lazy,1,0,map.size-1,left[i],right[i])
        update(tree, lazy,1,0,map.size-1,left[i], right[i],temp+1)
    }
//    for (i in tree) {
//        print("$i ")
//    }
//    println()
    print("${tree[1]}")
}

private fun lazyUpdate(tree: IntArray, lazy:IntArray,node:Int,start:Int,end:Int){
    when {
        lazy[node] != 0 -> {
            tree[node] = tree[node].coerceAtLeast(lazy[node])
            when {
                start != end -> {
                    lazy[node * 2] = lazy[node * 2].coerceAtLeast(lazy[node])
                    lazy[node * 2 + 1] = lazy[node * 2 + 1].coerceAtLeast(lazy[node])
                }
            }
            lazy[node] = 0
        }
    }
}

private fun update(tree: IntArray,lazy: IntArray,node: Int,start: Int,end: Int,left:Int,right:Int,chai:Int){
    lazyUpdate(tree, lazy, node, start, end)
    when {
        left > end || right < start -> {
            return
        }
        left <= start && end <= right -> {
            tree[node] = tree[node].coerceAtLeast(chai)
            if (start != end) {
                lazy[node * 2] = lazy[node * 2].coerceAtLeast(chai)
                lazy[node * 2 + 1] = lazy[node * 2 + 1].coerceAtLeast(chai)
            }
            return
        }
        else -> {
            update(tree, lazy, node * 2, start, (start + end) / 2, left, right, chai)
            update(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right, chai)
            tree[node] = tree[node * 2].coerceAtLeast(tree[node * 2 + 1])
        }
    }
}


private fun query(tree: IntArray,lazy: IntArray,node: Int,start: Int,end: Int,left: Int,right: Int):Int{
    lazyUpdate(tree, lazy, node, start, end)
    return when {
        left>end || right<start -> 0
        left<=start && end<=right -> tree[node]
        else -> {
            val temp1 = query(tree, lazy, node * 2, start, (start + end) / 2, left, right)
            val temp2 = query(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right)
            temp1.coerceAtLeast(temp2)
        }
    }
}
