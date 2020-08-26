
fun main(args: Array<String>) {
    val (n,r,c)=System.`in`.bufferedReader().readLine()
            .split(" ").map { it.toInt() }
    println(recursive(n,r,c))
}
private fun recursive(n:Int, r:Int, c:Int):Int{
    if(n==0)
        return 0
    var half=1
    for(i in 0 until n-1)
        half*=2
    if(r<half && c<half)
        return recursive(n-1,r,c)
    if(half in (r + 1)..c)
        return half*half+recursive(n-1,r,c-half)
    if(half in (c + 1)..r)
        return 2*half*half+ recursive(n-1,r-half,c)
    return 3*half*half+recursive(n-1,r-half,c-half)
}