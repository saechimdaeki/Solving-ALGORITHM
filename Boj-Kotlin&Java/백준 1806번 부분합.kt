package 백준

import java.util.*
import kotlin.math.min

fun main() {
    val sc=Scanner(System.`in`)
    val n=sc.nextInt()
    val s=sc.nextInt()
    val arr=IntArray(n+1)
    for(i in 0 until n)
        arr[i]=sc.nextInt()
    var (left,right,sum,answer)= intArrayOf(0,0,arr[0],n+1)
    while (right in left until n){
        when {
            sum<s -> {
                right++
                sum+=arr[right]
            }
            sum==s -> {
                answer= min(right-left+1,answer)
                right++
                sum+=arr[right]
            }
            sum>s -> {
                answer= min(right-left+1,answer)
                sum-=arr[left]
                left++
            }
        }
    }
    println(if(answer>n) 0 else answer)
}