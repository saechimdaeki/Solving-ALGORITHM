package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp=IntArray(n+1)
    var index=0
    dp[0]=arr[0]
    for(i in 1 until n){
        if(dp[index]<arr[i]){
            index++
            dp[index]=arr[i]
        }else{
            var (left,right)= arrayOf(0,index)
            while (left<right){
                val mid=(left+right)/2
                if(dp[mid]<arr[i]){
                    left=mid+1
                }else
                    right=mid
            }
            dp[right]=arr[i]
        }
    }
    println(index+1)

}
