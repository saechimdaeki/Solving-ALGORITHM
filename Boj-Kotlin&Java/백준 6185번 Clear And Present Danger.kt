package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val list= arrayListOf<Int>()
    repeat(m){
        list.add(br.readLine().toInt())
    }
    val arr=Array(n+1){IntArray(n+1)}
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
   var sum=0
    for(i in 0 until list.size-1){
        sum+=arr[list[i]][list[i+1]]
    }
    println(sum)
}