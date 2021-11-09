package 모음사전

val vowel= arrayOf('A','E','I','O','U')
lateinit var list:ArrayList<String>
class Solution {
    fun solution(word: String): Int {
        list = arrayListOf()
        (1..5).forEachIndexed { _, i -> dfs(0, "", i) }
        list.sort()
        return 1 + list
                .asSequence()
                .takeWhile { it != word }
                .count()
    }
    fun dfs(level:Int, now: String ,length :Int){
        when (level) {
            length -> {
                list.add(now)
                return
            }
            else -> (0 until 5).forEachIndexed { _, i ->
                dfs(level + 1, now + vowel[i], length)
            }
        }
    }
}

fun main() {
    val s=Solution()
    println(s.solution("AAAAE"))
    println(s.solution("AAAE"))
    println(s.solution("I"))
    println(s.solution("EIO"))

}