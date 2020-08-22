import kotlin.math.ceil
import kotlin.math.ln
import kotlin.math.min

private lateinit var arr:Array<Int>
private lateinit var tree:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(n+1){0}
    val toarray=br.readLine().split(" ").map { it.toInt() }
    for(i in 1..n)
        arr[i]=toarray[i-1]
    val h= ceil(ln(n.toDouble())/ ln(2.0)).toInt()
    val size= 1 shl h+1
    tree=Array(size){0}
    val m=br.readLine().toInt()
    init(1,1,n)
    repeat(m){
        //1이면 바꿈 2면 출력.
        val (method,a,b)=br.readLine().split(" ").map { it.toInt() }
        when(method){
            1 ->{
                update(1,1,n,a,b)
            }
            else ->{
                bw.write("${query(1,1,n,a,b)}\n")
            }
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
        tree[node]=min(tree[node*2],tree[node*2+1])
    }
}
private fun query(node:Int,start:Int,end:Int, i:Int, j:Int):Int{
    if(i>end|| j<start)
        return -1
    if(i<=start &&end<=j)
        return tree[node]
    val m1=query(node*2,start,(start+end)/2,i,j)
    val m2=query(node*2+1,(start+end)/2+1,end,i,j)
    return when {
        m1==-1 -> m2
        m2==-1 -> m1
        else -> return min(m1,m2)
    }
}
private fun update(node:Int,start:Int,end:Int,idx:Int,value:Int){
    if(idx<start||end<idx)
        return
    if(start==end){
        tree[node]=value
        return
    }
    update(node*2,start,(start+end)/2,idx,value)
    update(node*2+1,(start+end)/2+1,end,idx,value)
    tree[node]= min(tree[node*2],tree[node*2+1])
}

