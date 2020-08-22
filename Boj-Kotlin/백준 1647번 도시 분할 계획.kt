private var arr= mutableListOf<Triple<Int,Int,Int>>()
private lateinit var parent:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Triple(a,b,c))
    }
    parent=Array(n+1){0}
    for(i in 1..n)
        parent[i]=i
    arr=arr.sortedWith(compareBy { it.third }).toMutableList()
    var mst=0
    var cnt=0
    for(i in 0 until m)
    {
        val tmp=arr[i]
        if(cnt==n-2)
            break
        if(find(tmp.first)!=find(tmp.second))
        {
            mst+=tmp.third
            union(tmp.first,tmp.second)
            cnt++
        }
    }
    //println(cnt)
    println(mst)
}
private fun find(x:Int):Int{
    if(x==parent[x])
        return x;
    parent[x]=find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int)
{
    val (px,py)= intArrayOf(find(x),find(y))
    if(py>px)
        parent[py]=px
    else
        parent[px]=py
}