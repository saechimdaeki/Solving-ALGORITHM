package LeetCode684

class Solution {
    private lateinit var parent:IntArray
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        parent= IntArray(edges.size+1){it}
        val answer= arrayListOf<Int>()
        for (i in edges.indices) {
            val (from, to)= edges[i]
            when {
                find(from)==find(to) -> {
                    answer.add(from)
                    answer.add(to)
                }
                else -> union(from,to)
            }
        }
        return answer.toIntArray()
    }
    fun find(x:Int):Int{
        if(parent[x]==x) return x
        parent[x]=find(parent[x])
        return parent[x]
    }
    fun union(x:Int,y:Int){
        val (px,py)= arrayOf(find(x),find(y))
        if(px>py) parent[px]=py
        else parent[py]=px
    }
}