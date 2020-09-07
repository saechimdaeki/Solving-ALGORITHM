package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var cnt=1
    while (true){
        val (l,p,v)=br.readLine().split(" ").map { it.toInt() }
        if(l==0 && p==0 && v==0)
            break
        var tmp1= (v/p)*l
        var tmp2=if(v%p>l) l else v%p
        bw.write("Case $cnt: ${tmp1+tmp2}\n")
        cnt++
    }
    bw.flush()
}