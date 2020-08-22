fun main() {
    val (a,b,c)=System.`in`.bufferedReader().readLine()
            .split(" ").map { it.toLong() }
    println(calc(a,b,c))
}
private fun calc(a:Long,b:Long,c:Long):Long{
    return when {
        b==0L -> 1
        b==1L -> a%c
        b%2==0L -> {
            val tmp=calc(a,b/2,c)
            (tmp*tmp)%c
        }
        else -> (a*calc(a,b-1,c))%c
    }
}
