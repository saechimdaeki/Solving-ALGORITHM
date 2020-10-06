package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=IntArray(11){-1}
    var cnt=0
    repeat(n){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        if(arr[a]==-1 ){
            arr[a]=b
        }else{
            if(arr[a]!=b) {
                cnt++
                arr[a]=b
            }
        }
    }
    println(cnt)
}