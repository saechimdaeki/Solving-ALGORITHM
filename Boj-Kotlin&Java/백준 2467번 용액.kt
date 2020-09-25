package 백준

import kotlin.math.abs

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    //두개란것 명시
    var (sp,ep)= arrayOf(0,n-1)
    var liq= abs(arr[sp]+arr[ep])
    var (left,right)= arrayOf(arr[sp],arr[ep])
    while (sp<ep){
        val tmp=arr[sp]+arr[ep]
        if(abs(tmp)<liq){
            liq= abs(tmp)
            left=arr[sp]
            right=arr[ep]
        }
        when {
            tmp<0 -> {
                sp++
            }
            else -> ep--
        }
    }
    println("$left $right")
}