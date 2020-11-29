package 백준

import kotlin.system.exitProcess

private lateinit var parent:IntArray

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    parent=IntArray(n+1){it}
    (1..n).forEach { i ->
        val temp=br.readLine().split(" ").map { it.toInt() }
        temp.indices
                .asSequence()
                .filter { temp[it]==1 && find(i)!= find(it +1) }
                .forEach { union(i, it +1) }
    }
    val temp=br.readLine().split(" ").map { it.toInt() }
    val vertex=find(temp[0])
    (1 until m).forEach { i ->
        when {
            vertex!= find(temp[i]) -> {
                println("NO")
                exitProcess(0)
            }
        }
    }
    println("YES")

}
private fun find(x:Int):Int{
    when (x) {
        parent[x] -> return x
        else -> {
            parent[x] = find(parent[x])
            return parent[x]
        }
    }
}
private fun union(x:Int,y:Int){
    val (px,py)= intArrayOf(find(x), find(y))
    when {
        px<py -> parent[py]=px
        else -> parent[px]=py
    }
}
