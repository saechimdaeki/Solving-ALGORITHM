import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max
import kotlin.math.min
import kotlin.system.exitProcess

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var (n,m)=br.readLine().split(" ").map { it.toInt() }
    val g= Array(n){ arrayListOf<Int>()}
    val gr= Array(n){ arrayListOf<Int>()}
    val b=Array(n){0}
    val input=br.readLine().split(" ").map { it.toInt() }
    for(i in input.indices)
        b[i]=input[i]
    while (m-->0){
        val (u,v)=br.readLine().split(" ").map { it.toInt()-1 }
        g[u].add(v)
        gr[v].add(u)
    }
    val order=tsort(g)
    if(order.size!=n) {
        println(-1)
        exitProcess(0)
    }
    var answer=0
    var left=0
    var right=n-1
    order.reverse()
    while (left<=right)
    {
        val mid=(left+right)/2
        if(possible(mid,b,order,g)){
            left=mid+1
            answer= max(answer,mid)
        }else
            right=mid-1
    }
    order.reverse()
    val a=Array(n){0}
    for(x in order)
    {
        a[x]=1
        for(y in gr[x])
            a[x]=max(a[x],a[y]+1)
        if(x<answer)
            a[x]=b[x]
        else if (x==answer)
            a[x]= max(b[x]+1,a[x])
    }
    for(i in 0 until n)
        bw.write("${a[i]} ")
    bw.write("\n")
    bw.flush()
}
private fun tsort(g:Array<ArrayList<Int>>):ArrayList<Int>{
    val n=g.size
    val ind=Array(n){0}
    for(i in 0 until n)
    {
        for(j in g[i])
            ind[j]++
    }
    val order= arrayListOf<Int>()
    val q=LinkedList<Int>()
    for(i in 0 until n)
    {
        if(ind[i]==0)
        {
            q.offer(i)
            order.add(i)
        }
    }
    while (q.isNotEmpty())
    {
        val now=q.poll()
        for(i in g[now])
        {
            ind[i]--
            if(ind[i]==0)
            {
                q.offer(i)
                order.add(i)
            }
        }
    }
    return order
}
private fun possible(k:Int,b:Array<Int>,order:ArrayList<Int>,g:Array<ArrayList<Int>>):Boolean{
    val n= b.size
    val a=Array(n){0}
    for(x in order){
        a[x]=2000000000
        for(y in g[x])
            a[x]= min(a[x],a[y]-1)
        if(x<k){
            if(b[x]>a[x])
                return false
            a[x]=b[x]
        }
        if(a[x]<=0)
            return false
    }
   for(i in 0 until n)
   {
       if(a[i]>b[i])
           return true
       if(a[i]<b[i])
           return false
   }
    return true
}