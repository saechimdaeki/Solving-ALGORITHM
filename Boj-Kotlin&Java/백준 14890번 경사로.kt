package 백준

import kotlin.math.abs

/** doc
 * 첫째 줄에 N (2 ≤ N ≤ 100)과 L (1 ≤ L ≤ N)이 주어진다. 둘째 줄부터 N개의 줄에 지도가 주어진다.
 * 각 칸의 높이는 10보다 작거나 같은 자연수이다.
 */
private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,l)=br.readLine().split(" ").map { it.toInt() }
    arr=Array(n){ IntArray(n) }
    var answer=0
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    for(i in 0 until n){
        if(hangcheck(i,l,n))
            answer++
    }
    for(i in 0 until n){
        if(rowcheck(i,l,n))
            answer++
    }
    println("$answer")
}
private fun hangcheck(x:Int,l:Int,n:Int):Boolean{
    val height=IntArray(n)
    val visited=BooleanArray(n)
    for(i in 0 until n)
        height[i]=arr[x][i]
    for(i in 0 until n-1){
        if(height[i]==height[i+1]) continue
        if(abs(height[i]-height[i+1])>1) return false
        /* 내리막 */
        if(abs(height[i]-height[i+1])==1){
            if(height[i]-1 == height[i+1]){
                for(j in i+1 .. i+l){
                    if(j>=n || visited[j]||height[i+1]!=height[j])
                        return false
                    else
                        visited[j]=true
                }
            }
            /* 오르막 */
            else{
                for(j in i downTo i-l+1){
                    if(j<0 || visited[j]||height[i]!=height[j])
                        return false
                    else
                        visited[j]=true
                }
            }
        }
    }
    return true
}
private fun rowcheck(x:Int,l:Int,n:Int):Boolean{
    val height=IntArray(n)
    val visited=BooleanArray(n)
    for(i in 0 until n)
        height[i]=arr[i][x]
    for(i in 0 until n-1){
        if(height[i]==height[i+1]) continue
        if(abs(height[i+1]-height[i])>1) return false
        /* 내리막!*/
        if(abs(height[i]-height[i+1])==1){
            if(height[i]-1 == height[i+1]){
                for(j in i+1..i+l){
                    if(j>=n || visited[j] || height[i+1]!=height[j])
                        return false
                    else
                        visited[j]=true
                }
            }else{
                for(j in i downTo i-l+1){
                    if(j<0 || visited[j]|| height[i]!=height[j])
                        return false
                    else
                        visited[j]=true
                }
            }
        }
    }
    return true
}