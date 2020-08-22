import kotlin.math.*

private lateinit var arr:Array<Long>
private lateinit var tree:Array<Long>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").map { it.toLong() }.toTypedArray()
    val h = ceil(ln(n.toDouble()) / ln(2.0)).toInt()
    val size= 1 shl h+1
    tree=Array(size){0L}
    init(1,0,n-1)
    repeat(m){
        var (a,b,c,d)=br.readLine().split(" ")
        var (x,y,z)= intArrayOf(a.toInt()-1,b.toInt()-1,c.toInt()-1)
        val di=d.toLong()
        if(x>y){
            val tmp=x
            x=y
            y=tmp
        }
        bw.write("${query(1,0,n-1,x,y)}\n")
        update(1,0,n-1,z,di-arr[z])
        arr[z]=di
    }
    bw.flush()

}
private fun init(node:Int,start:Int,end:Int){
    if(start==end)
        tree[node]=arr[start]
    else{
        init(node*2,start,(start+end)/2)
        init(node*2+1,(start+end)/2+1,end)
        tree[node]=tree[node*2]+tree[node*2+1]
    }
}
private fun query(node:Int,start:Int,end:Int,i:Int,j:Int):Long{
    if(i>end || j<start)
        return -1
    if(i<= start && end<=j)
        return tree[node]
    val m1=query(node*2,start,(start+end)/2,i,j)
    val m2=query(node*2+1,(start+end)/2+1,end,i,j)
    return when {
        m1==-1L -> m2
        m2==-1L -> m1
        else -> return m1+m2
    }
}
private fun update(node:Int, start:Int,end:Int,idx:Int,d:Long){
    if(idx !in start..end)
        return
    tree[node]+=d
    if(start!=end){
        update(node*2,start,(start+end)/2,idx,d)
        update(node*2+1,(start+end)/2+1,end,idx,d)
    }
}