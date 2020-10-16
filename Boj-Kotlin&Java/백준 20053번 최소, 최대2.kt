package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        val arr=br.readLine().split(" ").map { it.toInt() }
        bw.write("${arr.min()} ${arr.max()}\n")
    }
    bw.flush()
}