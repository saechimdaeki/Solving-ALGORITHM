private var arr=ArrayList<Triple<Int,Int,Int>>()
private lateinit var parent:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    parent=Array(n+1){0}
    for(i in 0 until m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Triple(a,b,c))
    }
    for(i in 1..n)
        parent[i]=i
    val tmp=arr.sortedBy { it.third }
    arr.clear()
    arr.addAll(tmp)
    var mst=0
    for(i in 0 until m)
    {
        val tmp=arr[i]
        if(find(tmp.first)!=find(tmp.second))
        {
            mst+=tmp.third
            union(tmp.first,tmp.second)
        }
    }
    println(mst)
}
private fun find(x:Int):Int{
    if(x==parent[x])
        return x
    parent[x]=find(parent[x])
    return parent[x]
}
private fun union(x:Int, y:Int){
    var (px,py)= intArrayOf(find(x),find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}
