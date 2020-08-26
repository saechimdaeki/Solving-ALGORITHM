package 백준

import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var s=br.readLine()
    val bomb=br.readLine()
    val st= Stack<Char>()
    s=s.reversed()
    for(i in s.indices){
        st.add(s[i])
        if(s[i]==bomb[0] && st.size>=bomb.length){
            var bombbomb=true
            for(j in bomb.indices){
                if(bomb[j]!= st[st.size-1-j]){
                    bombbomb=false
                    break
                }
            }
            if(bombbomb) {
                for (j in bomb.indices) {
                    st.pop()
                }
            }
        }
    }
    when {
        st.isEmpty() -> bw.write("FRULA")
        else -> {
            while (st.isNotEmpty())
              bw.write("${st.pop()}")
        }
    }
    bw.flush()
}