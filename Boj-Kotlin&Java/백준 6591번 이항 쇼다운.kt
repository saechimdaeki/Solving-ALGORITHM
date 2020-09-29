package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while (true) {
        var (n, k) = br.readLine().split(" ").map { it.toInt() }
        var answer:Long=1
        var divide=1
        if(n==0 &&k==0) break
        if(n-k<k)
           k=n-k
        while (k-- >0){
            answer*=n--
            answer/=divide++
        }
        bw.write("$answer\n")
    }
    bw.flush()
}