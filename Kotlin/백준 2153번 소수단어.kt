import kotlin.math.sqrt

fun main(args: Array<String>) {
    val s=System.`in`.bufferedReader().readLine()
    var sum=0
    for(i in s.indices)
    {
        sum += if(s[i] in 'a'..'z')
            s[i]-'a'+1
        else
            s[i]-'A'+27
    }
  //  println(sum)
    if(isprime(sum))
        println("It is a prime word.")
    else
        println("It is not a prime word.")
}
private fun isprime(n:Int):Boolean
{
    if(n==1)
        return true
    var tmp= sqrt(n.toDouble()).toInt()
    for(i in 2..tmp)
    {
        if(n%i==0) {
            return false
        }
    }
    return true
}