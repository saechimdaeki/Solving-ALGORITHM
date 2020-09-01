package 백준

import java.util.*
import kotlin.math.max

//입력형식에 문제가있는 문제라 kotlin 평소방식불가능
fun main() {
    val sc=Scanner(System.`in`)
    val n=sc.nextInt()
    val k=sc.nextInt()
    val arr=IntArray(n){0}
    for(i in 0 until n)
        arr[i]=sc.nextInt()
    var answer=Int.MIN_VALUE
    var sum=0
    for(i in 0 ..n-k){
        for(j in i until i+k)
            sum+=arr[j]
        answer= max(answer,sum)
        sum=0
    }
    println(answer)
}