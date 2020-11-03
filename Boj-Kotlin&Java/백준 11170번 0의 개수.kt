package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()

    val t=br.readLine().toInt()
    repeat(t){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        var cnt=0
        for(i in a..b){
            val temp=i.toString()
            for(j in temp.indices){
                if(temp[j]=='0')
                    cnt++
            }
        }
        bw.write("$cnt\n")

    }
    bw.flush()
}