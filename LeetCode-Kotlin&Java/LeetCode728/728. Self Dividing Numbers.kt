package LeetCode728

class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val answer= arrayListOf<Int>()
        for(i in left ..right){
            val s=i.toString()
            var check=true
            if(s.contains('0'))
                check=false
            for (c in s) {
                if(c-'0'!=0) {
                    if (i % (c - '0') != 0) {
                        check = false
                    }
                }
            }
            if(check)
            answer.add(i)
        }
        return answer.toList()
    }
}

fun main() {
    val s= Solution()
    println("${s.selfDividingNumbers(1,22)}")
}