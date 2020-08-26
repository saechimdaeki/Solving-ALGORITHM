fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=Array(n){Array(m){0}}
    val brr=Array(n){Array(m){0}}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            brr[i][j]=input[j]
    }
    for(i in 0 until n)
    {
        for(j in 0 until m)
            bw.write("${arr[i][j]+brr[i][j]} ")
        bw.write("\n")
    }
    bw.flush()
}