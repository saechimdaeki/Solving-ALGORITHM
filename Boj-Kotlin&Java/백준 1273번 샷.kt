package 백준


import kotlin.math.ceil
import kotlin.math.ln


private lateinit var black:IntArray
private lateinit var gray:IntArray
private lateinit var white:IntArray
private lateinit var tree:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    black=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    gray=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    white=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var h=0
    (0 until n)
            .asSequence()
            .filter { h< black[it]+ gray[it]+ white[it]+1 }
            .forEach { h=black[it]+ gray[it]+ white[it]+1 }
    val y=IntArray(h + 1)
    y[0]=0
    y[1]=n
    for(i in 0 until n){
        y[black[i] + 1]++
        y[black[i] + gray[i] + 1]+=3
        y[black[i] + gray[i] + white[i] + 1]-=5
    }
    val x=IntArray(h + 1)
    for(i in 1..h)
        x[i]=x[i - 1]+y[i]
    val treeH= ceil(ln(h.toDouble()) / ln(2.0)).toInt()
    val size= 1 shl (treeH+1)
    tree= IntArray(size)
    init(tree,1,1,h)
    val m=br.readLine().toInt()
    val tmp=br.readLine().split(" ").map { it.toInt() }
    for(i in 0 until m){
        val k=kth(tree,1,1,h,tmp[i])
        bw.write("${x[k]}\n")
    }
    bw.flush()
}

private fun init(tree:IntArray,node:Int,start:Int,end:Int){
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

private fun kth(tree: IntArray,node: Int,start: Int,end: Int,k:Int):Int{
    return when (start) {
        end -> {
            tree[node]=0
            start
        }
        else -> {
            val ans = when {
                k <= tree[node * 2] -> kth(tree, node * 2, start, (start + end) / 2, k)
                else -> kth(tree, node * 2 + 1, (start + end) / 2 + 1, end, k - tree[node * 2])
            }
            tree[node] = tree[node * 2] + tree[node * 2 + 1]
            ans
        }
    }
}