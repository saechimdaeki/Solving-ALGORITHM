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
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ arrayListOf()}
    inr= IntArray(n+1)
    outr= IntArray(n+1)
    val tmp=br.readLine().split(" ").map { it.toInt() }
    tmp.indices.forEach { i ->
        when (val temp=tmp[i]) {
            -1 -> return@forEach
            else -> arr[temp].add(i + 1)
        }
    }
    dfs(1)
    val h= ceil(ln(t.toDouble())/ln(2.0)).toInt()
    val size=(1 shl (h+1))
    tree= IntArray(size)
    lazy= IntArray(size)
    repeat(m){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        updateRange(tree,lazy,1,1,t,inr[a],outr[a],b)
    }
    for(i in 0 until n)
        bw.write("${query(tree,lazy,1,1,t, inr[i+1])} ")
    bw.flush()
}

private fun updateLazy(tree:IntArray,lazy:IntArray,node:Int,start:Int,end:Int){
    when {
        lazy[node]!=0 -> {
            tree[node]+=(end-start+1)*lazy[node]
            when {
                start!=end -> {
                    lazy[node*2]+=lazy[node]
                    lazy[node*2+1]+=lazy[node]
                }
            }
            lazy[node]=0
        }
    }
}

private fun updateRange(tree: IntArray,lazy: IntArray,node: Int,start:Int,end:Int,left:Int,right:Int,chai:Int){
    updateLazy(tree,lazy,node,start,end)
    when {
        left>end || right<start -> return
        left<=start && end<=right -> {
            tree[node]+=(end-start+1)*chai
            when {
                start!=end -> {
                    lazy[node*2]+=chai
                    lazy[node*2+1]+=chai
                }
            }
            return
        }
        else -> {
            updateRange(tree, lazy, node * 2, start, (start + end) / 2, left, right, chai)
            updateRange(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right, chai)
            tree[node] = tree[node * 2] + tree[node * 2 + 1]
        }
    }
}
private fun query(tree: IntArray,lazy: IntArray,node: Int,start: Int,end: Int,idx:Int):Int{
    updateLazy(tree, lazy, node, start, end)
    return when {
        idx>end || idx<start -> 0
        start==end && start==idx -> tree[node]
        else -> {
            val mid = (start + end) / 2
            when {
                idx <= mid -> query(tree, lazy, node * 2, start, mid, idx)
                else -> query(tree, lazy, node * 2 + 1, mid + 1, end, idx)
            }
        }
    }
}