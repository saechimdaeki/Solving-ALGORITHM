package LeetCode1282

class Solution {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val list= arrayListOf<Pair<Int,Int>>()
        groupSizes.indices.mapTo(list) { Pair(it,groupSizes[it]) }
        list.sortBy { it.second }
        val answer= ArrayList<ArrayList<Int>>()
        val visit=BooleanArray(groupSizes.size)
        loop@for (i in list.indices) {
            when {
                visit[list[i].first] -> continue@loop
            }
            val count=list[i].second
            val tempList= arrayListOf<Int>()
            for(j in i until list.size){
                tempList.add(list[j].first)
                visit[list[j].first]=true
                when (tempList.size) {
                    count -> {
                        answer.add(tempList)
                        continue@loop
                    }
                }
            }
        }
        return answer
    }
}

fun main() {
    val s= Solution()
    val answer=s.groupThePeople(intArrayOf(3,3,3,3,3,1,3))
    println(answer)
}