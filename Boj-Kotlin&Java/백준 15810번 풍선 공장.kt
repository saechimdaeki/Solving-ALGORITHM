package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    arr.sort()
    var (left,right)= arrayOf(1, 1000000000000)
    while (left<=right){
        val mid=(left+right)/2
        var cnt:Long=0
        for(i in  arr.indices){
            cnt+=mid/arr[i]
        }
        if(cnt>=m){
            right=mid-1
        }else
            left=mid+1
    }
    println(left)
}