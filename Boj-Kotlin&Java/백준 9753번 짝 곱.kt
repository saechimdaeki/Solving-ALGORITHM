package 백준

import kotlin.math.min

private lateinit var sosoo:IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    sosoo=IntArray(100001){it}
    val arr= arrayListOf<Int>()
    for(i in 2..100000){
        if(sosoo[i]==0) continue
        else
            arr.add(i)
        for(j in (i+i) .. 100000 step i) {
            sosoo[j] = 0
        }
    }
    repeat(t){
        var mini=Int.MAX_VALUE
        val number=br.readLine().toInt()
        for(i in arr.indices){
            for(j in arr.indices){
                if(i==j) continue
                if(arr[i]*arr[j]>=number){
                    mini= min(mini,arr[i]*arr[j])
                    break
                }
            }
        }
        bw.write("$mini\n")
    }
    bw.flush()
}
