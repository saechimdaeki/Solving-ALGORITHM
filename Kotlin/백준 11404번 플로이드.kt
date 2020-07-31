private const val infi=1000000000
private lateinit var arr:Array<Array<Int>>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    arr=Array(n+1){Array(n+1){infi}}
    for(i in 1..n)
        for(j in 1..n)
            if(i==j)
                arr[i][j]=0

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map{it.toInt()}
        if(arr[a][b]>c)
            arr[a][b]=c
    }
    for(k in 1..n)
    {
        for(i in 1..n)
        {
            for(j in 1..n)
            {
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    for(i in 1..n) {
        for (j in 1..n) {
            if (arr[i][j] == infi)
                arr[i][j] = 0
            bw.write("${arr[i][j]} ")
        }
        bw.write("\n")
    }
    bw.flush()

}