package 백준

fun main() {
    val (n,m)= readLine()!!.split(" ").map { it.toInt() }
    println("${m-gcd(n,m)}")
}
private fun gcd(a:Int,b:Int):Int{
    if(b==0)
        return a
    return gcd(b,a%b)
}