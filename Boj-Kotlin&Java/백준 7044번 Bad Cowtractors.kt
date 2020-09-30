package 백준
private lateinit var parent:IntArray
private val arr= arrayListOf<Triple<Int,Int,Int>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    parent= IntArray(n+1){it}
    var mst=0
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Triple(a,b,c))
    }
    arr.sortByDescending { it.third }
    var cnt=0
    for(i in 0 until m){
        val tmp=arr[i]
        if(find(tmp.first) != find(tmp.second)){
            mst+=tmp.third
            union(tmp.first,tmp.second)
            cnt++
        }
    }
    println(if(cnt==n-1) mst else -1)
}
private fun find(x:Int):Int{
    if(x==parent[x])
        return x
    parent[x]=find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x),find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}