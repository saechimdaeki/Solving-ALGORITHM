import kotlin.math.ceil
import kotlin.math.ln

private lateinit var arr:Array<Long>
private lateinit var tree:Array<Long>
/* N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 주의하자... */
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    //n개수 m변경횟수 k합하는횟수
    val (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){0L}
    for(i in 0 until n)
        arr[i]=br.readLine().toLong()
    val h= ceil(ln(n.toDouble())/ ln(2.0)).toInt()
    val size= 1 shl h+1
    tree=Array(size){0L}
    init(1,0,n-1)
    repeat(m+k){
        var (method,a,b)=br.readLine().split(" ").map { it.toInt() }
        if(method==1){
            a--
            val diff=b-arr[a]
            arr[a]=b.toLong()
            update(1,0,n-1,a,diff)
        }else{
            bw.write("${query(1,0,n-1,a-1,b-1)}\n")
        }
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
    if(i>end||j<start)
        return 0
    if(i<=start && end<=j)
        return tree[node]
    val m1=query(node*2,start,(start+end)/2,i,j)
    val m2=query(node*2+1,(start+end)/2+1,end,i,j)
    return m1+m2
}
private fun update(node:Int,start:Int,end:Int,i:Int,diff:Long){
    if(i<start || i>end)
        return
    tree[node]=tree[node]+diff
    if(start!=end){
        update(node*2,start,(start+end)/2,i,diff)
        update(node*2+1,(start+end)/2+1,end,i,diff)

    }
}