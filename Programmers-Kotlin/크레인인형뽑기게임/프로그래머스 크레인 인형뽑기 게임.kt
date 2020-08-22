package 메인디렉.크레인인형뽑기게임

import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val n= board.size
        val reverseboard=Array(n){Array(n){0}}
        for(i in n-1 downTo 0) //x
        {
            for(j in 0 until n)
            {
                reverseboard[n-1-i][j]=board[i][j]
            }
        }
        val st=Stack<Int>()
        for(i in moves.indices)
        {
            for(j in n-1 downTo 0)
            {
                if(reverseboard[j][moves[i]-1]!=0)
                {
                    if( st.isNotEmpty()&& st.peek()==reverseboard[j][moves[i]-1]) {
                        st.pop()
                        answer+=2
                    }else
                    st.push(reverseboard[j][moves[i]-1])
                    reverseboard[j][moves[i]-1]=0
                    break
                }
            }
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    val arr=Array(5){IntArray(0)}
    arr[0]= intArrayOf(0,0,0,0,0)
    arr[1]= intArrayOf(0,0,1,0,3)
    arr[2]= intArrayOf(0,2,5,0,1)
    arr[3]= intArrayOf(4,2,4,4,2)
    arr[4]= intArrayOf(3,5,1,3,1)
    println(s.solution(arr, intArrayOf(1,5,3,5,1,2,1,4)))

}