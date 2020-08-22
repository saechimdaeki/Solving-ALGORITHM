fun main(args: Array<String>) {
    val (a,b,c)=System.`in`.bufferedReader().readLine().split(" ").map { it.toLong() }
    println(pow(a,b,c))
}
private fun pow(a:Long,b:Long,c:Long):Long{
    if(b==1L)
        return a%c
    var tmp=pow(a,b/2,c)
    tmp=tmp*tmp%c
    if(b%2==0L)
        return tmp
    return tmp*a%c
}