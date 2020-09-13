package 백준

import java.util.*
import kotlin.collections.HashMap

private val stack=Stack<Double>()
private val map=HashMap<Char,Double>()
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val s=br.readLine()
    val list= arrayListOf<Double>()
    repeat(n){
        list.add(br.readLine().toDouble())
    }
    var cnt=0
    for(i in s.indices){
        if(s[i] in 'A'..'Z') {
            if(map.containsKey(s[i])) continue
            map[s[i]] = list[cnt]
            cnt++
        }
    }
    for(i in s.indices){
        if(s[i] in 'A'..'Z')
            stack.push(map[s[i]])
        else{
            val a= stack.pop()
            val b= stack.pop()
            stack.push(calc(a,b,s[i]))
        }
    }
    val answer=String.format("%.2f", stack.pop())
    println(answer)
}
private fun calc(a:Double,b:Double,c:Char):Double{
    var answer:Double=0.0
    when(c){
        '+' -> return a+b
        '-' -> return b-a
        '*'->return a*b
        '/' -> return b/a
    }
    return answer
}