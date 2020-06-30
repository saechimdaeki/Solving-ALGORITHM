package boj14681kot

import java.lang.StringBuilder

fun main(args:Array<String>)
{
    val mod=1000000009
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    var sb=StringBuilder()
    var arr=Array(100001) {IntArray(4){0} }
    for(i in 1..100000){
        if(i-1 >=0){
            arr[i][1]=arr[i-1][2]+arr[i-1][3]
            if(i==1)
                arr[i][1]=1
        }
        if(i-2 >=0){
            arr[i][2]=arr[i-2][1]+arr[i-2][3]
            if(i==2)
                arr[i][2]=1
        }
        if(i-3>=0){
            arr[i][3]=arr[i-3][1]+arr[i-3][2]
            if(i==3)
                arr[i][3]=1
        }
        arr[i][1]%=mod
        arr[i][2]%=mod
        arr[i][3]%=mod
    }
    for(i in 0 until n step 1){
        val tmp=br.readLine().toInt()
        sb.append((((Integer.toUnsignedLong(arr[tmp][1]+arr[tmp][2]+arr[tmp][3])%mod)).toString()+"\n"))
    }
    print(sb)

}