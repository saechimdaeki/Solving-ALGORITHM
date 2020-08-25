import kotlin.system.exitProcess

private lateinit var parent:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val g=br.readLine().toInt()
    val p=br.readLine().toInt()
    parent= IntArray(g+1)
    for(i in 1..g)
        parent[i]=i
    var cnt=0
    repeat(p){
        val airPlaneInput=br.readLine().toInt()
        val tmp=find(airPlaneInput)
        if(tmp==0)
        {
            println(cnt)
            exitProcess(0)
        }else{
            cnt++
            union(tmp,tmp-1)
        }
    }
    println(cnt)
}
private fun find(x:Int):Int{
    if(parent[x]==x)
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