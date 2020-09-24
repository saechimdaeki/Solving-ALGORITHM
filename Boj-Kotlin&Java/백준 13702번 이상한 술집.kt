package 백준

private val arr= arrayListOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    repeat(n){
        arr.add(br.readLine().toInt())
    }
    var (left,right)= intArrayOf(1, arr.maxOrNull()!!)
    var answer=0
    while (left<=right){
        val mid=(left+right)/2
        if(possible(mid,k)){
            answer=mid
            left=mid+1
        }else{
            right=mid-1
        }
    }
    println(answer)
}
private fun possible(len:Int,k:Int):Boolean{
    var cnt=0
    for(i in arr)
        cnt+=i/len
    return cnt >= k
}