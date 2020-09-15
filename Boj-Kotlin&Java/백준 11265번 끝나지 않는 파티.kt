private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){IntArray(n+1)}
    for(i in 1..n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j+1]=input[j]
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        if(arr[a][b]<=c)
            bw.write("Enjoy other party\n")
        else
            bw.write("Stay here\n")
    }
    bw.flush()
}