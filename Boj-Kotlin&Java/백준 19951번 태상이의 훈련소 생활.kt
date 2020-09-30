package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    repeat(m){
        val (a,b,k)=br.readLine().split(" ").map { it.toInt() }
        for(i in a-1 until b){
            arr[i]+=k
        }
    }
    for(i in arr)
        bw.write("$i ")
    bw.flush()
}
/* 원래는 누적합으로 푸는게 정석 */