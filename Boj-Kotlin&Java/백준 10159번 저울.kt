package 백준

private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    arr=Array(n+1){ IntArray(n+1){1000000000} }
    for(i in 1..n){
        for(j in 1..n)
            if(i==j) arr[i][j]=0
    }
    repeat(m){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr[a][b]=1
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    for(i in 1..n){
        var cnt=0
        for(j in 1..n){
            if(i==j) continue
            if(arr[i][j]==1000000000&&arr[j][i]==1000000000)
                cnt++
        }
        bw.write("$cnt\n")
    }
    bw.flush()
}