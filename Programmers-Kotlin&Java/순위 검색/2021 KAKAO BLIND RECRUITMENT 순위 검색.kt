package kakao


import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Solution {
    private val map=HashMap<String,Int>()
    val scoreList=Array(4*3*3*3){ ArrayList<Int>()}
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        map["-"] = 0
        map["cpp"] = 1
        map["java"] = 2
        map["python"] = 3
        map["backend"]=1
        map["frontend"]=2
        map["junior"]=1
        map["senior"]=2
        map["chicken"]=1
        map["pizza"]=2
        for (s in info) {
            val word=s.split(" ")
            val arr= intArrayOf(
                    map[word[0]]!! *3 *3 *3,
                    map[word[1]]!! *3 *3 ,
                    map[word[2]]!! *3,
                    map[word[3]]!!)
            val score=word[4].toInt()

            (0 until (1 shl 4)).forEach { i ->
                val idx= (0 until 4)
                        .asSequence()
                        .filter { (i and (1 shl it))!=0 }
                        .sumBy { arr[it] }
                scoreList[idx].add(score)
            }
        }
        (0 until 4*3*3*3)
                .forEach { i ->
                    scoreList[i].sort()
                }



        val answer=IntArray(query.size)
        for(i in query.indices){
            val word=query[i].split(" ")
            val idx=map[word[0]]!! *3 *3 *3 +
                    map[word[2]]!! *3 *3 +
                    map[word[4]]!! *3 +
                    map[word[6]]!!
            val score=word[7].toInt()
            val ret =lower_bound(scoreList[idx],score)
            answer[i]=scoreList[idx].size-ret
        }
        return answer
    }
    fun lower_bound(list:ArrayList<Int>, value: Int):Int{
        var left=0
        var right=list.size
        while (left<right){
            val mid=(left+right)/2
            if(list[mid]>=value)
                right=mid
            else
                left=mid+1
        }
        return left
    }

}

fun main() {
    val s=Solution()
    val answer1=s.solution(arrayOf("java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50")
    , arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"))
    for (i in answer1) {
        print("$i ")
    }
    println()
}