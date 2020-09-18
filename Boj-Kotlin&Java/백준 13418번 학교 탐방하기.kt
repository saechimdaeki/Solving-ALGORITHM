package 백준

private val arr=ArrayList<Triple<Int,Int,Int>>()
private lateinit var parent:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    parent= IntArray(n+1){it}
    repeat(m+1){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        if(c==0)
            arr.add(Triple(a,b,1))
        else
            arr.add(Triple(a,b,0))
    }
    arr.sortBy { it.third }
    var mst=0
    var maxst=0
    for(i in arr){
        val tmp=i
        if(find(tmp.first)!= find(tmp.second)){
            mst+=tmp.third
            union(tmp.first,tmp.second)
        }
    }
    parent= IntArray(n+1){it}
    for(i in arr.size-1 downTo 0){
        val tmp=arr[i]
        if(find(tmp.first)!= find(tmp.second)){
            maxst+=tmp.third
            union(tmp.first,tmp.second)
        }
    }
    println("${(maxst*maxst)- (mst*mst)} ")

}
private fun find(x:Int):Int{
    if(parent[x]==x)
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