package LeetCode784


class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val answerList = arrayListOf<String>()

        answerList.add(s)
        s.indices.forEach { i ->
            when {
                Character.isLetter(s[i]) -> {
                    val n = answerList.size
                    (0 until  n).forEach { j ->
                        val toCharArray = answerList[j].toCharArray()
                        when {
                            Character.isUpperCase(toCharArray[i]) -> {
                                toCharArray[i] = Character.toLowerCase(toCharArray[i])
                            }
                            else -> {
                                toCharArray[i] = Character.toUpperCase(toCharArray[i])
                            }
                        }
                        answerList.add(String(toCharArray))
                    }
                }
            }
        }
        return answerList
    }
}
