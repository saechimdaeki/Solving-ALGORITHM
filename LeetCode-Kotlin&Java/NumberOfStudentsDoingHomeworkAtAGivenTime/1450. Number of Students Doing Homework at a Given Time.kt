package NumberOfStudentsDoingHomeworkAtAGivenTime

class Solution {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var answer=0
        for (i in startTime.indices) {
            if(queryTime in startTime[i] .. endTime[i])
                answer++
        }
        return answer
    }
}