package 백준

import kotlin.math.ceil
import kotlin.math.ln

private val arr= arrayListOf<Int>()
private  lateinit var answer:IntArray
private lateinit var tree:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val h= ceil(ln(n.toDouble())/ln(2.0)).toInt()
    val size=(1 shl (h+1))
    answer= IntArray(n+1)
    tree= IntArray(size)
    arr.add(-1)
    repeat(n){
        arr.add(br.readLine().toInt())
    }
    init(tree,1,1,n)
    (1..n).forEach { i ->
        val k=arr[i]+1
        val w=calc(tree,1,1,n,k)
        answer[w]=i
        update(tree,1,1,n,w,-1)
    }
    (1.. n)
            .forEach { i ->
                bw.write("${answer[i]}\n")
            }
    bw.flush()
}

private fun init(tree:IntArray,node:Int, start:Int, end:Int){
    when (start) {
        end -> {
            tree[node]=1
            return
        }
        else -> {
            init(tree, node * 2, start, (start + end) / 2)
            init(tree, node * 2 + 1, (start + end) / 2 + 1, end)
            tree[node] = tree[node * 2] + tree[node * 2 + 1]
        }
    }
}
private fun update(tree:IntArray,node:Int,start:Int,end:Int,index:Int, chai:Int){
    when {
        index>end || index<start -> {
            return
        }
        start==end -> {
            tree[node]+=chai
            return
        }
        else -> {
            update(tree, node * 2, start, (start + end) / 2, index, chai)
            update(tree, node * 2 + 1, (start + end) / 2 + 1, end, index, chai)
            tree[node] = tree[node * 2] + tree[node * 2 + 1]
        }
    }
}
private fun calc(tree:IntArray, node:Int, start:Int, end:Int, index:Int):Int{
    return when {
        start==end -> start
        index<=tree[node*2] -> calc(tree,node*2,start,(start+end)/2,index)
        else -> calc(tree, node * 2 + 1, (start + end) / 2 + 1, end, index - tree[node * 2])
    }
}
