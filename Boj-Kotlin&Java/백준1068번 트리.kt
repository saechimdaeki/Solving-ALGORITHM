import kotlin.system.exitProcess

private lateinit var visited:BooleanArray
private lateinit var tree:Array<ArrayList<Int>>
private var answer=0
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    visited=BooleanArray(n)
    tree=Array(n){ArrayList<Int>()}
    var rootNode=0
    val input=br.readLine().split(" ").map { it.toInt() }

    for (i in input.indices) {
        val parent=input[i]
        if(parent==-1) rootNode=i
        else{
            tree[i].add(parent)
            tree[parent].add(i)
        }
    }
    val remove=br.readLine().toInt()
    if(remove==rootNode) {
        println(0)
        exitProcess(0)
    }
    dfs(rootNode,remove)
    println("$answer")
}
private fun dfs(n:Int,r:Int){
    visited[n]=true
    var cnt=0
    (0 until tree[n].size).forEach { i ->
        val next=tree[n][i]
        when {
            !visited[next] && next!=r -> {
                cnt++
                dfs(next,r)
            }
        }
    }
    if(cnt==0) answer++
}