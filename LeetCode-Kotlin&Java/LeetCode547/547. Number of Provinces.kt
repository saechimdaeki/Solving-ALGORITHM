package LeetCode547

class Solution {
    private lateinit var parent:IntArray
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        parent= IntArray(isConnected.size){it}
        isConnected.indices.forEach { i ->
            isConnected[i].indices
                    .asSequence()
                    .filter { isConnected[i][it]==1 }
                    .forEach { union(i, it) }
        }
        val list= arrayListOf<Int>()
        isConnected.indices.forEach { i ->
            parent[i]=find(i)
            list.add(parent[i])
        }
        return list.distinct().size
    }
    fun find(x:Int):Int{
        when (x) {
            parent[x] -> return x
            else -> {
                parent[x] = find(parent[x])
                return parent[x]
            }
        }
    }
    fun union(x:Int,y:Int){
        val (px,py)= intArrayOf(find(x),find(y))
        when {
            px<py -> parent[py]=px
            else -> parent[px]=py
        }
    }
}