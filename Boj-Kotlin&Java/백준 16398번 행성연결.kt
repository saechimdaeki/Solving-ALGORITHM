package 백준

private lateinit var parent:IntArray
private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    parent= IntArray(n+1){it}
    arr=Array(n+1){IntArray(n+1)}
    for(i in 1..n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices){
            arr[i][j+1]=input[j]
        }
    }
    val list= arrayListOf<Triple<Int,Int,Int>>()
    for(i in 1..n){
        for(j in i+1..n){
            list.add(Triple(i,j,arr[i][j]))
        }
    }
    var answer:Long=0
    list.sortBy { it.third }
    for(i in list.indices){
        if(find(list[i].first)!= find(list[i].second)){
            answer+=list[i].third
            union(list[i].first,list[i].second)
        }
    }
    println("$answer")
}
private fun find(x:Int):Int{
    if(x== parent[x])
        return x
    parent[x]= find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x), find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}