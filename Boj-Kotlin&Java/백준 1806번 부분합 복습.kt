package 백준

import java.util.*
import kotlin.math.min

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,s)=br.readLine().split(" ").map { it.toInt() }
    val st=StringTokenizer(br.readLine())
    val arr=IntArray(n){0}
    for(i in 0 until n)
        arr[i]=st.nextToken().toInt()
    var answer=100000001
    /* 문제 입력조건에 problem이 있는문제임 split list화하면 런타임 에러뜸*/
    var (sum,start,end)= arrayOf(0,0,0)
    loop@ while (true){
        when {
            sum>=s -> {
                sum-=arr[start++]
                answer= min(answer,(end-start)+1)
            }
            end==n -> break@loop
            else -> sum+=arr[end++]
        }
    }
    println(if(answer== 100000001) 0 else answer)
}