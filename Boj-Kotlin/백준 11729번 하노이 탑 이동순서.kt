private val bw=System.out.bufferedWriter()
fun main(args: Array<String>) {
    val n=System.`in`.bufferedReader().readLine().toInt()
    var k=1
    for(i in 0 until n)
        k*=2
    bw.write("${k-1}\n")
    hanoi(1,3,n)
    bw.flush()
}
private fun hanoi(a:Int, b:Int, n:Int){
     if(n==1) {
         bw.write("$a $b\n")
         return
     }
    hanoi(a,6-a-b,n-1)
    bw.write("$a $b\n")
    hanoi(6-a-b,b,n-1)
}