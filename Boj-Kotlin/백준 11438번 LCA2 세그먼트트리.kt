import kotlin.math.ceil
import kotlin.math.ln

private lateinit var arr:Array<ArrayList<Int>>
private lateinit var first:Array<Int>
private lateinit var level:Array<Int>
private lateinit var dfs_susoon:Array<Int>
private lateinit var tree:Array<Int>
private var idx=0
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var n=br.readLine().toInt()
    arr=Array(n+1){ArrayList<Int>()}
    for(i in 0 until n-1)
    {
        val (x,y)=br.readLine().split(" ").map{it.toInt()}
        arr[x].add(y)
        arr[y].add(x)
    }
    var m= 2*(n-1)+1
    first=Array(n+1){-1}
    dfs_susoon=Array(m){0}
    level=Array(m){0}
    dfs(1,0,0)
    for(i in 0 until m)
    {
        val tmp=dfs_susoon[i]
        if(first[tmp]==-1)
            first[tmp]=i
    }
    n=m
    val h= ceil(ln(n.toDouble())/ ln(2.0)).toInt()
    val size= 1 shl h+1
    tree=Array(size){0}
    init(1,0,n-1)
    m=br.readLine().toInt()
    repeat(m){
        val (u,v)=br.readLine().split(" ").map { it.toInt() }
        var i=first[u]
        var j=first[v]
        if(i>j)
        {
            val tmp=i
            i=j
            j=tmp
        }
        bw.write("${dfs_susoon[query(1,0,n-1,i,j)]}\n")
    }
    bw.flush()
}
private fun init(node:Int,start:Int,end:Int){
    if(start==end)
        tree[node]=start
    else{
        init(node*2,start,(start+end)/2)
        init(node*2+1,(start+end)/2+1,end)
        if(level[tree[node*2]]<level[tree[node*2+1]])
            tree[node]=tree[node*2]
        else
            tree[node]=tree[node*2+1]
    }
}
private fun query(node:Int,start:Int,end:Int,i:Int,j:Int):Int{
    if(i>end||j<start)
        return -1
    if(i<=start && end<=j)
        return tree[node]
    val m1=query(2*node,start,(start+end)/2,i,j)
    val m2=query(2*node+1,(start+end)/2+1,end,i,j)
    if(m1==-1)
        return m2
    else if(m2==-1)
        return m1
    else{
        if(level[m1]<level[m2])
            return m1
        else
            return m2
    }
}
private fun dfs(node:Int,parent:Int,depth:Int){
    dfs_susoon[idx]=node
    level[idx]=depth
    idx++
    for(i in arr[node])
    {
        if(i==parent)
            continue
        dfs(i,node,depth+1)
        dfs_susoon[idx]=node
        level[idx]=depth
        idx++
    }

}