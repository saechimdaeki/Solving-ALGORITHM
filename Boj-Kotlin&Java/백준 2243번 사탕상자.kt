package 백준

import kotlin.math.ceil
import kotlin.math.ln

private const val candy=1000000
private val arr=IntArray(candy+1)
private lateinit var tree:IntArray

private fun update(tree: IntArray,node: Int,start: Int,end: Int,idx:Int,chai:Int){
    when {
        idx<start || idx>end -> return
        else -> {
            tree[node] = tree[node] + chai
            when {
                start != end -> {
                    update(tree, node * 2, start, (start + end) / 2, idx, chai)
                    update(tree, node * 2 + 1, (start + end) / 2 + 1, end, idx, chai)
                }
            }
        }
    }
}
private fun calc(tree: IntArray,node: Int,start: Int,end: Int,idx:Int):Int{
    return when (start) {
        end -> start
        else -> when {
            idx<=tree[node*2] -> {
                calc(tree,node*2,start,(start+end)/2,idx)
            }
            else -> calc(tree,node*2+1,(start+end)/2+1,end,idx-tree[node*2])
        }
    }
}

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val h= ceil(ln(candy.toDouble())/ln(2.0)).toInt()
    val size=(1 shl (h+1))
    tree= IntArray(size)
    repeat(n){
        val tmpArr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        when {
            tmpArr[0]==2 -> {
                arr[tmpArr[1]]+=tmpArr[2]
                update(tree,1,1, candy,tmpArr[1],tmpArr[2])
            }
            tmpArr[0]==1 -> {
                val box=calc(tree,1,1, candy,tmpArr[1])
                bw.write("$box\n")
                arr[box]--
                update(tree,1,1, candy,box,-1)
            }
        }
    }
    bw.flush()
}