package 백준


private lateinit var parent:IntArray
private lateinit var visited:BooleanArray
private lateinit var arr:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m,k)=br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    parent= IntArray(n+1){it}
    visited= BooleanArray(n+1)
    var cost=0
    repeat(m){
        val (x,y)=br.readLine().split(" ").map { it.toInt() }
        union(x,y)
    }
    for(i in 1..n){
        val tmp= find(i)
        if(visited[tmp]) continue
        visited[tmp]=true
        cost+=arr[tmp-1]
    }
    println(if(cost>k) "Oh no" else cost)
}
private fun find(x:Int):Int{
    if(parent[x]==x)
        return x
    parent[x]= find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= arrayOf(find(x), find(y))
    /*
    if(px>py)
        parent[px]=py
    else
        parent[py]=px
     */
    if(arr[px-1]<arr[py-1])
        parent[py]=px
    else
        parent[px]=py
}