package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val sum=IntArray(n+1)
    repeat(m){
        val (a,b,k)=br.readLine().split(" ").map { it.toInt() }
        sum[a-1]+=k
        sum[b]-=k
    }
    bw.write("${arr[0]+sum[0]} ")
    for(i in 1 until n){
        sum[i]+=sum[i-1]
        bw.write("${sum[i]+arr[i]} ")
    }
    bw.flush()
}