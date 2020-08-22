package 메인디렉.모의고사

class Solution {
    fun solution(answers: IntArray): IntArray {
        val oneguy= intArrayOf(1,2,3,4,5)
        val twoguy= intArrayOf(2,1,2,3,2,4,2,5)
        val threeguy= intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var answer = arrayListOf<Int>()
        var (onecnt,twocnt,threecnt)= arrayOf(Pair(0,1),Pair(0,2),Pair(0,3))
        for(i in answers.indices) {
            if (answers[i] == oneguy[i % 5])
                onecnt=onecnt.copy(first = onecnt.first+1,second = onecnt.second)
            if (answers[i] == twoguy[i % 8])
                twocnt=twocnt.copy(first = twocnt.first+1,second = twocnt.second)
            if (answers[i] == threeguy[i % 10])
                threecnt=threecnt.copy(first = threecnt.first+1,second = threecnt.second)
        }
        val arr= listOf(onecnt,twocnt,threecnt).sortedByDescending { it.first }
        answer.add(arr[0].second)
        if(arr[1].first==arr[0].first)
            answer.add(arr[1].second)
        if(arr[2].first==arr[0].first)
            answer.add(arr[2].second)
        return answer.sorted().toIntArray()
    }
}

fun main() {
    val s=Solution()
    val answer1=s.solution(intArrayOf(1,2,3,4,5))
    println("answer1=================")
    for(i in answer1)
        print("$i ")
    println()
    println("answer2===============")
    val answer2 = s.solution(intArrayOf(1,3,2,4,2))
    for(i in answer2)
        print("$i ")
}