package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        val dp=IntArray(n+1)
        var temp= arrayListOf<Int>()
        for(i in 0 until n){
            temp.add(br.readLine().toInt())
        }
        val arr=temp.toIntArray()
        dp[0]=arr[0]
        var idx=0
        (1 until n).forEach { i ->
            if(dp[idx]<arr[i]){
                dp[++idx]=arr[i]
            }else{
                val loc= lower_bound(dp,arr[i],idx)
                dp[loc]=arr[i]
            }
        }
        bw.write("${idx+1}\n")
    }
    bw.flush()
}
private fun lower_bound(a:IntArray,key:Int,idx:Int):Int{
    var left=0
    var right=idx+1
    while (left<right){
        val mid=(left+right)/2
        if(a[mid]<key){
            left=mid+1
        }else
            right=mid
    }
    return left
}