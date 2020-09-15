private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ IntArray(n+1){1000000000} }
    for(i in 1..n){
        for(j in 1..n){
            if(i==j) arr[i][j]=0
        }
    }
    repeat(m){
        val (a,b,c)=br.readLine().split(" ").map { it.toInt() }
        if(c==0) {
            arr[a][b] = 0
            arr[b][a]=1
        }
        else{
            arr[a][b]=0
            arr[b][a]=0
        }
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    val k=br.readLine().toInt()
    repeat(k){
        val (s,e)=br.readLine().split(" ").map { it.toInt() }
        bw.write("${arr[s][e]}\n")
    }
    bw.flush()
}