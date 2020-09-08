package 백준
private lateinit var parent:IntArray
private val list= arrayListOf<Triple<Int,Int,Int>>()
private lateinit var arr:IntArray
fun main() {
    val (n, m, k) = readLine()!!.split(" ").map { it.toInt() }
    arr= readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    parent=IntArray(n+1){it}
    for(i in arr.indices)
        parent[arr[i]]=0
    repeat(m){
        val (x,y,z)= readLine()!!.split(" ").map { it.toInt() }
        list.add(Triple(x,y,z))
    }
    list.sortWith(compareBy { it.third })
    var answer=0
    for(i in list.indices){
        if(find(list[i].first)!= find(list[i].second)) {
            answer += list[i].third
            union(list[i].first,list[i].second)
        }
    }
    println(answer)
}
private fun find(x:Int):Int{
    if(parent[x]==0)
        return 0
    if(x== parent[x])
        return x
    parent[x]=find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x), find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}