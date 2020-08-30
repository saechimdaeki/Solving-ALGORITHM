package 백준

import kotlin.system.exitProcess

private lateinit var arr:IntArray
//연산은 +-1 ?
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer=-1
    if(n==1){
        println(0)
        exitProcess(0)
    }
    for(i in -1..1){ //첫항이차이
        for(j in -1..1){ //두번째항의 차이
            var change=0 //연산의 횟수
            if(i!=0)
                change++
            if(j!=0)
                change++
            val tmp=arr[0]+i   //첫 항
            val diff=(arr[1]+j)-tmp //공차
            var ok=true
            var sooYl=tmp+diff
            for(k in 2 until n){
                sooYl+=diff
                if(arr[k]==sooYl) continue
                if(arr[k]-1==sooYl) change++
                else if(arr[k]+1==sooYl) change++
                else{
                    ok=false
                    break
                }
            }
            if(ok){
                if(answer==-1 || answer>change)
                    answer=change
            }
        }
    }
    println(answer)
}