package 백준
private val dp=Array(32){ LongArray(32)}
fun main() {
    var (n,l,I)= readLine()!!.split(" ").map { it.toLong() }
    for(i in 0 ..31){
        dp[0][i]=1
    }
    for(i in 1..31){
        dp[i][0]=dp[i-1][0]
        for(j in 1..31){
            dp[i][j]=dp[i-1][j]+dp[i-1][j-1]
        }
    }
    while (n>0){
        if(I<=dp[(n-1).toInt()][l.toInt()]){
            print("0")
            n--
        }else{
            print("1")
            I-=dp[(n-1).toInt()][l.toInt()]
            n--
            l--
        }
    }
}