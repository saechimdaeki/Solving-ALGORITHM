package 백준
private lateinit var arr: IntArray
fun main() {
    val br=System.`in`.bufferedReader()
    val (m,n)= br.readLine().split(" ").map { it.toInt() }
    arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var (left,right)= intArrayOf(1,arr.max()!!)
    var answer=0
    while (left<=right){
        val mid=(left+right)/2
        when {
            isTrue(mid,m) -> {
                answer=mid
                left=mid+1
            }
            else -> right=mid-1
        }
    }
    println(answer)
}
private fun isTrue(length:Int,m:Int):Boolean{
    var cnt=0
    for(i in arr)
        cnt+=(i/length)
    return cnt >= m
}