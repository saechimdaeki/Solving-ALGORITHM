package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    var (n,k)=br.readLine().split(" ").map { it.toInt() }
    val arr=IntArray(n)
    for(i in 0 until n)
        arr[i]=br.readLine().toInt()
    arr.sortDescending()
    var answer=0
    for(i in arr.indices){
        answer+=k/arr[i]
        k%=arr[i]
    }
    println(answer)
}