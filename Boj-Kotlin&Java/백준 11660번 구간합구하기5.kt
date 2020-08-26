fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val map=Array(n){Array(n){0}}

    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            map[i][j]=input[j]
    }
    val s=Array(n+1){Array(n+1){0}}
    for(i in 1..n)
    {
        for(j in 1..n){
            s[i][j]=s[i-1][j]+s[i][j-1]-s[i-1][j-1]+map[i-1][j-1]
        }
    }

    repeat(m){
        val (x1,y1,x2,y2)=br.readLine().split(" ").map { it.toInt() }
        bw.write("${s[x2][y2]- s[x1-1][y2] -s[x2][y1-1] +s[x1-1][y1-1]}\n")
    }
    bw.flush()
}