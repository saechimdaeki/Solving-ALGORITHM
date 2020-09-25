package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var (start,end)= arrayOf(0,0)
    var sum=0
    var answer=0
    while (true){
        if(sum>=m)
            sum-=arr[start++]
        else if(end==n) break
        else sum+=arr[end++]
        if(sum==m) answer++
    }
    print(answer)
}