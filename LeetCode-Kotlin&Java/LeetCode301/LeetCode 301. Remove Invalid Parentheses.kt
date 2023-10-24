package 코틀린.LeetCode.LeetCode301

import java.util.*

class Solution {
    fun removeInvalidParentheses(s: String): List<String> {
        val set = mutableSetOf<String>()
        val answer = mutableListOf<String>()
        val minSize = minSize(s)
        dfs(s, minSize, set, answer)
        return answer
    }

    fun minSize(s: String ): Int {
        val stack = Stack<Char>()

        s.indices.forEach {
            val now = s[it]
            when {
                s[it] == '(' -> stack.add(now)
                s[it] == ')' -> {
                    when {
                        stack.isEmpty() -> stack.add(now)
                        stack.peek() == ')' -> stack.add(now)
                        stack.peek() == '(' -> stack.pop()
                    }
                }
            }
        }
        return stack.size
    }

    fun dfs(s: String, minSize: Int, set: MutableSet<String>, answer : MutableList<String>) {
        if (set.contains(s))
            return
        set.add(s)
        if (minSize == 0) {
            val size = minSize(s)
            if (size==0)
                answer.add(s)
            return
        }

        for (i in s.indices) {
            val first = s.substring(0,i)
            val second = s.substring(i+1)
            dfs(first+second, minSize-1, set, answer)
        }
    }
}

fun main() {
    Solution().apply {
        println(removeInvalidParentheses("()())()")) // ["(())()","()()()"]
        println(removeInvalidParentheses("(a)())()")) // ["(a())()","(a)()()"]
        println(removeInvalidParentheses(")(")) // [""]
    }
}