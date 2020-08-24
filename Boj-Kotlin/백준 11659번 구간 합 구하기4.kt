fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }
    val s=Array(n+1){0}
    for(i in 1..n)
        s[i]=s[i-1]+arr[i-1]
    repeat(m){
        val (x,y)=br.readLine().split(" ").map { it.toInt() }
        bw.write("${s[y]-s[x-1]}\n")
    }
    bw.flush()
}