package 백준

import kotlin.math.ceil
import kotlin.math.ln
private lateinit var arr:LongArray
private lateinit var tree:LongArray
private lateinit var lazy:LongArray
private fun init(arr:LongArray,tree:LongArray,node:Int,start:Int,end:Int):Long{
    return when (start) {
        end -> {
            tree[node]=arr[start]
            tree[node]
        }
        else -> {
            tree[node] = init(arr, tree, node*2, start, (start+end)/2) + init(arr, tree, node*2+1, (start+end)/2+1, end);
            tree[node]
        }
    }
}
private fun lazyUpdate(tree: LongArray,lazy:LongArray,node:Int,start:Int,end:Int){
    when {
        lazy[node] !=0L -> {
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
private fun update(tree: LongArray,lazy: LongArray,node: Int,start: Int,end: Int,left:Int,right:Int,chai:Long){
    lazyUpdate(tree,lazy,node,start,end)//
    when {
        left>end || right<start -> return
        left<=start && end<=right -> {
            tree[node]+=((end-start+1)*chai)
            when {
                start!=end -> {
                    lazy[node*2]+=chai
                    lazy[node*2+1]+=chai
                }
            }
            return
        }
        else -> {
            update(tree, lazy, node * 2, start, (start + end) / 2, left, right, chai)
            update(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right, chai)
            tree[node] = tree[node * 2] + tree[node * 2 + 1]
        }
    }
}
private fun sum(tree: LongArray,lazy: LongArray,node: Int,start: Int,end: Int,left: Int,right: Int):Long{
    lazyUpdate(tree, lazy, node, start, end)
    return when {
        left>end || right<start -> 0
        left<=start && end<=right -> tree[node]
        else -> sum(tree, lazy, node * 2, start, (start + end) / 2, left,
                right) + sum(tree, lazy, node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    }
}
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    m+=k
    arr= LongArray(n)
    var idx=0
    repeat(n){
        arr[idx++]=br.readLine().toLong()
    }
    val h= ceil(ln(n.toDouble())/ln(2.0)).toInt()
    val size=(1 shl (h+1))
    tree= LongArray(size)
    lazy= LongArray(size)
    init(arr,tree,1,0,n-1)
    repeat(m){
        val tempArray=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        when (tempArray[0]) {
            1 -> {
                update(tree,lazy,1,0,n-1,tempArray[1]-1,tempArray[2]-1,tempArray[3].toLong())
            }
            2 -> {
                bw.write("${sum(tree,lazy,1,0,n-1,tempArray[1]-1,tempArray[2]-1)}\n")
            }
        }
    }
    bw.flush()
}