package 프로그래머스.섬연결하기

class Solution1 {
    private lateinit var parent:IntArray
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        parent=IntArray(n+1){it}
        val arr= arrayListOf<Triple<Int,Int,Int>>()
        for(i in costs.indices){
            arr.add(Triple(costs[i][0],costs[i][1],costs[i][2]))
        }
        arr.sortBy { it.third }
        for(i in arr.indices){
            val tmp=arr[i]
            if(find(tmp.first)!=find(tmp.second)){
                union(tmp.first,tmp.second)
                answer+=tmp.third
            }
        }
        return answer
    }
    fun find(x:Int):Int{
        if(x==parent[x])
            return x
        parent[x]=find(parent[x])
        return parent[x]
    }
    fun union(x:Int,y:Int){
        val (px,py)= arrayOf(find(x),find(y))
        if(px>py)
            parent[px]=py
        else
            parent[py]=px
    }
}

fun main() {
    val solution=Solution1()
    println("${solution.solution(4, arrayOf(intArrayOf(0,1,1), intArrayOf(0,2,2), intArrayOf(1,2,5), intArrayOf(1,3,1), intArrayOf(2,3,8)))}")

}