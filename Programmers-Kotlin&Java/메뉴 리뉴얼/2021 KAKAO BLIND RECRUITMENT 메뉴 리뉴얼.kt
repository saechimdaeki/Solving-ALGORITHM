package kakao


class Solution {
    val foodmap= Array(11){HashMap<String,Int>()}
    val maxCnt=IntArray(11)
    fun solution(orders: Array<String>, course: IntArray): Array<String> {

        val ans= arrayListOf<String>()
        for (order in orders) {
            val arr=order.toCharArray()
            arr.sort()
            dfs(arr,0,StringBuilder())
        }
        for (i in course) {
           for(map in foodmap[i]){
               if(map.value>=2 && map.value==maxCnt[i]){
                    ans.add(map.key)
               }
           }
        }
        ans.sort()
        val answer=Array(ans.size){""}
        for (i in ans.indices) {
            answer[i]=ans[i]
        }
        return answer
    }
    fun dfs(str:CharArray, idx:Int, candidate:StringBuilder){
        when { //기저 case
            idx>=str.size -> {
                val len=candidate.length
                when {
                    len>=2 -> {
                        val cnt= foodmap[len].getOrDefault(candidate.toString(),0)+1
                        foodmap[len][candidate.toString()] = cnt
                        maxCnt[len]= maxOf(maxCnt[len],cnt)
                    }
                }
                return
            }
            else -> {
                dfs(str, idx + 1, candidate.append(str[idx])) // choice O
                candidate.setLength(candidate.length - 1) // 위에서 append했던거 지움
                dfs(str, idx + 1, candidate)// choice X

            }
        }

    }
}

fun main() {
    val s=Solution()
    val answer1= s.solution(arrayOf("ABCFG","AC","CDE","ACDE","BCFG","ACDEH"), intArrayOf(2,3,4))
    for (s in answer1) {
        print("$s ")
    }
    println()
}