private var arr= mutableListOf<Triple<Int,Int,Int>>()
private lateinit var parent:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val (v,e)=br.readLine().split(" ").map { it.toInt() }
    parent=Array(v+1){0}
    for(i in 1 .. v)
        parent[i]=i
    for(i in 0 until e)
    {
        val (a,b,c)=br.readLine().split(" ").map { it.toInt()}
        arr.add(Triple(a,b,c))
    }
    arr=arr.sortedWith(compareBy { it.third }).toMutableList()
    var mst=0
    for(i in 0 until e)
    {
        val tmp=arr[i]
        if(find(tmp.first)!=find(tmp.second))
        {
            mst+=tmp.third
            union(tmp.first,tmp.second)
        }
    }
    print(mst)
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