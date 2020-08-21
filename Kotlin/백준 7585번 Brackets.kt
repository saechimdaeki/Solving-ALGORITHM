import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while (true)
    {
        val s=br.readLine()
        if(s=="#")
            break
        val stack=Stack<Char>()
        var check=true
        loopfor@for(i in s.indices)
        {
            if(s[i]=='('||s[i]=='{'||s[i]=='[')
                stack.push(s[i])
            else if(s[i]==')'||s[i]=='}'||s[i]==']')
            {
                if(stack.isEmpty()) {
                   check=false
                    break@loopfor
                }
                val tmp=stack.pop()
                when {
                    s[i]==')' -> {
                        if(tmp!='('){
                            check=false
                            break@loopfor
                        }
                    }
                    s[i]==']' -> {
                        if(tmp!='[') {
                            check=false
                            break@loopfor
                        }
                    }
                    s[i]=='}' -> {
                        if(tmp!='{') {
                            check=false
                            break@loopfor
                        }
                    }
                }
            }
        }
        if(!check||stack.isNotEmpty())
            bw.write("Illegal\n")
        else
            bw.write("Legal\n")
    }
    bw.flush()
}