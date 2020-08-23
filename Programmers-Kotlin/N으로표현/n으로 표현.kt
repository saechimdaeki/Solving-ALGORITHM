package 메인디렉.N으로표현
class Solution {
    var answer=-1
    fun solution(N: Int, number: Int): Int {
        bruteforce(N,number,0,0)
        return answer
    }
    fun bruteforce(N:Int,number: Int,cnt:Int, previous:Int){
        var tmp=N
        if(cnt>8){
            answer=-1
            return
        }
        if(number==previous){
            if(answer==-1||answer>cnt)
                answer=cnt
            return
        }
        for(i in 0 until 8-cnt)
        {
            bruteforce(N,number,cnt+i+1,previous-tmp)
            bruteforce(N,number,cnt+i+1,previous+tmp)
            bruteforce(N,number,cnt+i+1,previous*tmp)
            bruteforce(N,number,cnt+i+1,previous/tmp)
            tmp=tmp*10+N
        }
    }
}
fun main() {
    val s= Solution()
    println(s.solution(5,12))
    println(s.solution(2,11))
}