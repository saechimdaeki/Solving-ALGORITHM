fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val m=br.readLine().toInt()
    val arr=br.readLine().split(" ").map{it.toInt()}.toIntArray()
    val d=Array(m+1){Array(20){0}}
    for(i in 1..m)
        d[i][0]=arr[i-1]
    for(j in 1 until 20)
    {
        for(i in 1 ..m)
            d[i][j]=d[d[i][j-1]][j-1]
    }
    val querry=br.readLine().toInt()
    repeat(querry){
        var (a,b)=br.readLine().split(" ").map { it.toInt() }
        for(i in 0 until 20)
        {
            if (a and (1 shl i) >0)
                b=d[b][i]
        }
        bw.write("$b\n")
    }
    bw.flush()
}