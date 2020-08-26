import kotlin.math.abs

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    val xpoint=Array(n+1){0L}
    val ypoint=Array(n+1){0L}
    for(i in 0 until n)
    {
        val input=br.readLine().split(" ").map { it.toLong() }
        xpoint[i]=input[0]
        ypoint[i]=input[1]
    }
    xpoint[n]=xpoint[0]
    ypoint[n]=ypoint[0]
    var answer=0L
    for(i in 0 until n)
    {
        answer+=xpoint[i]*ypoint[i+1]
        answer-=ypoint[i]*xpoint[i+1]
    }
    answer= abs(answer)
    bw.write("${answer/2}.")
    if(answer%2==0L)
        bw.write("0")
    else
        bw.write("5")
    bw.flush()

}