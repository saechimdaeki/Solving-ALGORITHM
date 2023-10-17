package 코틀린.LeetCode.LeetCode1694

class Solution {
    fun reformatNumber(number: String): String {
        val replace = number.replace("-", "").replace(" ", "")
        var len = replace.length
        when {
            len <= 3 -> return replace
            else -> {
                val sb = StringBuilder(replace)
                var i = 3
                while (len > 4) {
                    sb.insert(i, "-")
                    len -= 3
                    i += 4
                }
                while (len == 4) {
                    i--
                    sb.insert(i, "-")
                    len -= 2
                }
                return sb.toString()
            }
        }
    }
}