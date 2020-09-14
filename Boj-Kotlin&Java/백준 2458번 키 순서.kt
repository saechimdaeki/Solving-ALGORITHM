package 백준

private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n+1){ IntArray(n+1){1000000000}}
    for(i in 1..n){
        for(j in 1..n)
            if(i==j)
                arr[i][j]=0
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
    val array=IntArray(n+1)
    var answer=0
    for(i in 1..n){
        for(j in 1..n){
            if(i==j) continue
            if(arr[i][j]<1000000000){
                array[i]++
                array[j]++
                if(array[i]==n-1) answer++
                if(array[j]==n-1) answer++
            }
        }
    }
    println(answer)
}