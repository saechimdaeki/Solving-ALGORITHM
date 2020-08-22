import kotlin.math.*

private lateinit var arr:Array<Int>
private lateinit var tree:Array<Int>
private lateinit var maxtree:Array<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){0}
    for(i in 0 until n)
        arr[i]=br.readLine().toInt()
    val h = ceil(ln(n.toDouble()) / ln(2.0)).toInt()
    val size= 1 shl h+1
    tree=Array(size){0}
    maxtree=Array(size){0}
    init(1,0,n-1)
    repeat(m){
        val (start,end)=br.readLine().split(" ").map { it.toInt()-1 }
        val tmp=query(1,0,n-1,start,end)
        bw.write("${tmp.first} ${tmp.second}\n")
    }
    bw.flush()
}
private fun init(node:Int,start:Int,end:Int){
    if(start==end) {
        tree[node] = arr[start]
        maxtree[node]=arr[start]
    }
    else{
        init(node*2,start,(start+end)/2)
        init(node*2+1,(start+end)/2+1,end)
        tree[node]=min(tree[node*2],tree[node*2+1])
        maxtree[node]= max(maxtree[node*2],maxtree[node*2+1])
    }
}
private fun query(node:Int,start:Int,end:Int,i:Int,j:Int):Pair<Int,Int>{
    if(i>end || j<start)
        return Pair(1000000000,0)
    if(i<= start && end<=j)
        return Pair(tree[node],maxtree[node])
    val m1=query(node*2,start,(start+end)/2,i,j)
    val m2=query(node*2+1,(start+end)/2+1,end,i,j)
    return Pair(min(m1.first,m2.first), max(m1.second,m2.second))
}