package 프로그래머스.튜플

class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableSetOf<Int>()
        val tmp=s.split("},")
        val list= arrayListOf<String>()
        for(i in tmp.indices){
            var s=""
            for(j in tmp[i]){
                if(j=='{'||j=='}') continue
                s+=j
            }
            list.add(s)
        }
        list.sortBy { it.length }
        for(i in list) {
            val tmp=i.split(",")
            for(j in tmp.indices)
                answer.add(tmp[j].toInt())
        }
        return answer.toIntArray()
    }
}

fun main() {
    val s=Solution()
    val answer1=s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
    for(i in answer1)
        print("$i ")
    println("====================")
    val answer2=s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")
    for(i in answer2)
        print("$i ")
    println("====================")

    val answer3=s.solution("{{20,111},{111}}")
    for(i in answer3)
        print("$i ")
    println("====================")

    val answer4=s.solution("{{123}}")
    for(i in answer4)
        print("$i ")
    println("====================")
    val answer5=s.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")
    for(i in answer5)
        print("$i ")
}