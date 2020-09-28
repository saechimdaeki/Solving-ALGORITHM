package 백준

import java.util.*

private val set= mutableSetOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val a=br.readLine().toInt()
        val arr=IntArray(a)
        var st=StringTokenizer(br.readLine())
        for(i in 0 until a)
            arr[i]=st.nextToken().toInt()
        val b=br.readLine().toInt()
        st=StringTokenizer(br.readLine())
        val brr=IntArray(b)
        for(i in 0 until b)
            brr[i]=st.nextToken().toInt()
        val c=br.readLine().toInt()
        val crr=IntArray(c)
        st= StringTokenizer(br.readLine())
        for(i in 0 until c)
            crr[i]=st.nextToken().toInt()
        val answer= mutableSetOf<Int>()
        for(i in 0 until a){
            for(j in 0 until b){
                for(k in 0 until c){
                    val tmp=(arr[i]+brr[j]+crr[k]).toString()
                    var check=true
                    for(l in tmp.indices){
                        if(tmp[l]!='5'){
                            if(tmp[l]!='8'){
                                check=false
                                break
                            }
                        }
                    }
                    if(check)
                        answer.add(arr[i]+brr[j]+crr[k])
                }
            }
        }
        bw.write("${answer.size}\n")
    }
    bw.flush()
}
