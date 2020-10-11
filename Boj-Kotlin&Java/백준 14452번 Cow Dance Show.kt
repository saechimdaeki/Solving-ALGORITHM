package 백준

import java.util.PriorityQueue

private val q=PriorityQueue<Int>()
private val arr= arrayListOf<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    repeat(n){
        arr.add(br.readLine().toInt())
    }
    var answer=0
    var (left,right)= arrayOf(1,n)
    while (left<=right){
        val mid=(left+right)/2
        if(possible(mid,k)){
            right=mid-1
            answer=mid
        }else
            left=mid+1
    }
    println(answer)
}
private fun possible(mid:Int,k:Int):Boolean{
    var temp=0
    for(i in 0 until mid){
        q.offer(arr[i])
    }
    for(i in mid until arr.size){
        temp=q.poll()
        temp+=arr[i]
        if(temp>k) return false
        q.offer(temp)
    }
    temp=0
    q.clear()
    return temp<=k
}