package boj14681kot

fun main(args:Array<String>)
{
    var long:Long=0
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var arr=Array(101) {IntArray(10){0}}
    for (i in 1..9)
        arr[1][i]=1
    for (i in 2..n){
        for(j in 0..9){
            arr[i][j]=0
            if (j-1>=0){
                arr[i][j]+= arr[i-1][j-1]
            }
            if(j+1<=9){
                arr[i][j]+=arr[i-1][j+1]
            }
            arr[i][j]%=1000000000
        }
    }
    for (i in 0..9)
        long+=arr[n][i]
    println(long%1000000000)
}