import kotlin.math.*

private lateinit var arr:Array<Int>
private lateinit var tree:Array<Int>
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
    init(1,0,n-1)
    repeat(m){
        val (start,end)=br.readLine().split(" ").map { it.toInt()-1 }
        bw.write("${query(1,0,n-1,start,end)}\n")
    }
    bw.flush()

}
private fun init(node:Int,start:Int,end:Int){
    if(start==end)
        tree[node]=arr[start]
    else{
        init(node*2,start,(start+end)/2)
        init(node*2+1,(start+end)/2+1,end)
        tree[node]=min(tree[node*2],tree[node*2+1])
    }
}
private fun query(node:Int,start:Int,end:Int,i:Int,j:Int):Int{
    if(i>end || j<start)
        return -1
    if(i<= start && end<=j)
        return tree[node]
    val m1=query(node*2,start,(start+end)/2,i,j)
    val m2=query(node*2+1,(start+end)/2+1,end,i,j)
    return when {
        m1==-1 -> m2
        m2==-1 -> m1
        else -> return min(m1,m2)
    }
}