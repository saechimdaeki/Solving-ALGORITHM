package 백준

private lateinit var parent:IntArray
private lateinit var sex:BooleanArray
private var arr= mutableListOf<Triple<Int,Int,Int>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    parent= IntArray(n+1){it}
    sex=BooleanArray(n+1) //true남자 false 여자로 하장.
    val input=br.readLine().split(" ")
    for (i in 1..n){
        when {
            input[i-1]=="M" -> sex[i]=true
        }
    }
    repeat(m){
        val (x,y,z)=br.readLine().split(" ").map { it.toInt() }
        if(sex[x]!=sex[y])
        arr.add(Triple(x,y,z))
    }
   arr.sortWith(compareBy { it.third })
    var mst=0
    var cnt=0
    for(i in 0 until arr.size){
        val tmp=arr[i]
        if(find(tmp.first)!= find(tmp.second)) {
            mst += tmp.third
            union(tmp.first,tmp.second)
            cnt++
        }
    }
    when {
        cnt!=n-1 -> println(-1)
        else -> println(mst)
    }

}
private fun find(x:Int):Int{
    if(x== parent[x])
        return x
    parent[x]= find(parent[x])
    return parent[x]
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x),find(y))
    if(px<py)
        parent[py]=px
    else
        parent[px]=py
}