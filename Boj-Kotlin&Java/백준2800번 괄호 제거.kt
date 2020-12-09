package 백준

import java.util.*

private val set= mutableSetOf<Int>()
private val stringset= mutableSetOf<String>()
private lateinit var bracket:IntArray
/* () 최대 10개 */
fun main() {
    val s= readLine()!!
    var bracketCnt=0
    bracket= IntArray(s.length)
    val st=Stack<Int>()
    for(i in s.indices){
        when(s[i]){
            '('->{
                bracket[i]=bracketCnt
                st.push(bracketCnt++)
            }
            ')'->{
                bracket[i]=st.pop()
            }
        }
    }
    recur(0,"",s,s.length)
    val arr= arrayListOf<String>()
    arr.addAll(stringset)
    arr.sort()
    for (s1 in arr) {
        println(s1)
    }
}
private fun recur(idx:Int,curs:String,inputs:String,len:Int){
    when {
        idx==len && curs != inputs  && !stringset.contains(curs) -> {
            stringset.add(curs)
        }
    }
    when {
        idx==len -> return
        inputs[idx]=='(' -> {
            recur(idx+1, "$curs(",inputs,len)
            set.add(bracket[idx])
            recur(idx+1,curs,inputs,len)
            set.remove(bracket[idx])
        }
        inputs[idx]==')' && set.contains(bracket[idx]) -> recur(idx+1,curs,inputs,len)
        else -> recur(idx+1,curs+inputs[idx],inputs,len)
    }
}
