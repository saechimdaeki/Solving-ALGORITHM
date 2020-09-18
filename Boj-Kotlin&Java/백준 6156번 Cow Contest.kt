package 백준


fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=Array(n+1){BooleanArray(n+1)}
    repeat(m){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr[a][b]=true
    }
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(arr[i][k]&&arr[k][j])
                    arr[i][j]=true
            }
        }
    }
    var answer=0
    for(i in 1..n){
        var cnt=0
        for(j in 1..n)
            if(arr[i][j]||arr[j][i]) cnt++
        if(cnt==n-1) answer++
    }
    println(answer)
}