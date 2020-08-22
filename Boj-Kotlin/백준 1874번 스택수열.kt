package boj14681kot

import java.lang.StringBuilder
import java.util.*

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var sb=StringBuilder()
    val n=br.readLine().toInt()
    var arrayList= arrayListOf<Int>()
    for(i in 0 until n step 1)
        arrayList.add(br.readLine().toInt())
    var stack= Stack<Int>()
    var m=0
    for(i in arrayList)
    {
        if(i>m){
            while(i>m){
                stack.push(++m)
                sb.append("+\n")
            }
        }else{
            if(stack.peek()!=i){
                print("NO")
                return
            }
        }
        stack.pop()
        sb.append("-\n")
    }
    bw.write(sb.toString())
    bw.flush()
}