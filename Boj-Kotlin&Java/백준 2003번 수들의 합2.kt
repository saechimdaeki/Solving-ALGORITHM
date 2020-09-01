package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val arr=IntArray(n+1)
    val input=br.readLine().split(" ").map { it.toInt() }
    for(i in 0 until n)
        arr[i]=input[i]
    var (left,right,sum,answer)= intArrayOf(0,0,arr[0],0)
    while (right in left until n){
        if(sum<m){
            right++
            sum+=arr[right]
        }else if(sum==m){
            answer++
            right++
            sum+=arr[right]
        }else if(sum>m){
            sum-=arr[left]
            left++
            if(left in (right + 1) until n){
                right=left
                sum=arr[left]
            }
        }
    }
    println(answer)
}