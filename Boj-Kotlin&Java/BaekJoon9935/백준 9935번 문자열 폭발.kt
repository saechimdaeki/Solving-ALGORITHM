package BaekJoon9935

import java.util.*


fun main() {
    val br=System.`in`.bufferedReader()
    val s=br.readLine()
    val bomb=br.readLine()
    val st= Stack<Char>()
    s.indices.forEach { i ->
        st.push(s[i])
        when {
            st.size >=bomb.length -> {
                val isTrue= bomb.indices.any { st[st.size-bomb.length+ it] !=bomb[it] }
                when {
                    !isTrue -> {
                        repeat(bomb.indices.count()) {
                            st.pop()
                        }
                    }
                }
            }
        }
    }
    val sb=StringBuffer()
    while (st.isNotEmpty())
        sb.append(st.pop())
    sb.reverse()
    println(sb.ifEmpty { "FRULA" })
}