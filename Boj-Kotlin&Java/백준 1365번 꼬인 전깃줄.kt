package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp=IntArray(n+1)
    dp[0]=arr[0]
    var idx=1
    for(i in 1 until n){
        if(dp[idx-1]<arr[i]){
            dp[idx]=arr[i]
            idx++
            continue
        }
        var (left,right)= arrayOf(0,idx-1)
        while (left<=right){
            val mid=(left+right)/2
            if(dp[mid]>=arr[i])
                right=mid-1
            else
                left=mid+1
        }
        dp[left]=arr[i]
    }
    println(n-idx)
}
