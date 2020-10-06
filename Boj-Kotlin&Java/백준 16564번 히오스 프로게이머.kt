package 백준


private val arr= arrayListOf<Long>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    repeat(n){
        arr.add(br.readLine().toLong())
    }
    var (left,right)= arrayOf(arr.min()!!,arr.max()!!)
    var answer=0L
    while (left<=right){
        val mid=(left+right)/2
        var sum=0L
        for(i in arr.indices){
            if(arr[i]<=mid) sum+=mid-arr[i]
        }
        when {
            k>=sum -> {
                left=mid+1
                answer= maxOf(answer,mid)
            }
            else -> right=mid-1
        }
    }
    println(answer)
}
