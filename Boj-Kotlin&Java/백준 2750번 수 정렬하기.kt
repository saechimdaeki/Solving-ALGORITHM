fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val arr= Array(n){0}
    for(i in 0 until n)
        arr[i]=br.readLine().toInt()
    arr.sorted().forEach { bw.write("$it\n") }
    bw.flush()
}