import kotlin.math.*

private lateinit var arr:Array<Int>
private lateinit var tree:Array<Long>
private const val div= 1000000007
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){0}
    for(i in 0 until n)
        arr[i]=br.readLine().toInt()
    val h = ceil(ln(n.toDouble()) / ln(2.0)).toInt()
    val size= 1 shl h+1
    tree=Array(size){0L}
    init(1,0,n-1)
    repeat(m+k){
        val (type,start,end)=br.readLine().split(" ").map { it.toInt() }
        when (type) {
            1 -> {
                update(1,0,n-1,start-1,end)
                arr[start-1]=end
            }
            else -> {
                bw.write("${query(1,0,n-1,start-1,end-1)}\n")
            }
        }
    }
    bw.flush()
}
private fun init(node:Int,start:Int,end:Int){
    if(start==end)
        tree[node]=arr[start]%div.toLong()
    else{
        init(node*2,start,(start+end)/2)
        init(node*2+1,(start+end)/2+1,end)
        tree[node]=(tree[node*2]*tree[node*2+1])%div
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
        else -> return (m1*m2)%div
    }
}
private fun update(node:Int,start:Int,end:Int,idx:Int,value:Int){
    if(idx in start..end){
        if(start==end){
            tree[node]=value%div.toLong()
        }else{
            val mid=(start+end)/2
            update(node*2,start,mid,idx,value)
            update(node*2+1,mid+1,end,idx,value)
            tree[node]=(tree[node*2]*tree[node*2+1])%div
        }
    }
}