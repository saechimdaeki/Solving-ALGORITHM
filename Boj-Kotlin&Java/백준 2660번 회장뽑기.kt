package 백준

import kotlin.math.max
import kotlin.math.min

private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(n){ IntArray(n){1000000000}}
    for(i in 0 until n){
        for(j in 0 until n)
            if(i==j) arr[i][j]=0
    }
    while (true){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        if(a==-1 && b==-1) break
        arr[a-1][b-1]=1
        arr[b-1][a-1]=1
    }
    for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    val hoobolist=IntArray(n)
    var hoobo=-1
    for(i in 0 until n){
        var max=0
        max=max(max,arr[i].max()!!)
        hoobolist[i]=max
        if(hoobo>max || hoobo==-1)
            hoobo=max
    }
    var cnt=0
    for(i in 0 until n){
        if(hoobolist[i]==hoobo)
            cnt++
    }
    bw.write("$hoobo $cnt\n")
    for(i in 0 until n){
        if(hoobolist[i]==hoobo)
            bw.write("${i+1} ")
    }
    bw.flush()
}