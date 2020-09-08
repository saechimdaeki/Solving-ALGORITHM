package 메인디렉.기능개발

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = arrayListOf<Int>()
        val tmp= arrayListOf<Int>()
        var temp=0
        for(i in progresses.indices)
        {
            temp=(100-progresses[i])%speeds[i]
            if(temp>0)
                tmp.add((100-progresses[i])/speeds[i]+1)
            else
                tmp.add((100-progresses[i])/speeds[i])
        }
        temp=tmp[0]
        var cnt=0
        for(i in tmp.indices)
        {
            if(temp<tmp[i])
            {
                answer.add(cnt)
                cnt=1
                temp=tmp[i]
            }else
                cnt++
            if(i==tmp.size-1)
                answer.add(cnt)
        }

        return answer.toIntArray()
    }
}

fun main() {
    val s=Solution()
    val answer1=s.solution(intArrayOf(93,30,55), intArrayOf(1,30,5))
    for(i in answer1)
        print("$i ")
}