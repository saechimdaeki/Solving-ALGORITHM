package 메인디렉.조이스틱

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        for(i in name.indices)
        {
            val sang=name[i]-'A'
            val ha='Z'-name[i]+1
            answer+=if(sang<ha) sang else ha
        }
        var min=name.length-1
        for(i in name.indices)
        {
            if(name[i]!='A'){
                var next=i+1
                while (next<name.length && name[next]=='A')
                    next++
                val m=2*i+name.length-next
                min= kotlin.math.min(min,m)
            }
        }
        return answer+min
    }
}

fun main() {
    val s=Solution()
    println(s.solution("JEROEN"))
    println(s.solution("JAN"))
}