package kakao

class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        val playSec=time(play_time)
        val advSec=time(adv_time)
        val totalSec=IntArray(100*3600+1)
        logs.forEach { log ->
            val start=time(log.substring(0,8))
            val end=time(log.substring(9,17))

            (start until end).forEach { i ->
                totalSec[i]++
            }
        }
        var cur= adv_time.indices
                .asSequence()
                .map { totalSec[it].toLong() }
                .sum()
        var maxsum=cur
        var idx=0
        (advSec until playSec).forEach { i ->
            cur=cur+totalSec[i]-totalSec[i - advSec]
            when {
                cur> maxsum -> {
                    maxsum = cur
                    idx=(i-advSec)+1
                }
            }
        }
        return String.format("%02d:%02d:%02d",idx/3600,idx/60%60,idx%60)
    }

    fun time(t:String):Int{
        val nums=t.split(":").map { it.toInt() }
        return (nums[0]*60*60)+(nums[1]*60)+nums[2]
    }
}

fun main() {
    val s= Solution()
    println("${s.solution("02:03:55","00:14:15", arrayOf("01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"))}")
}