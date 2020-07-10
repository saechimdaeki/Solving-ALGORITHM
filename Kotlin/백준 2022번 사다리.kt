import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.min
import kotlin.math.sqrt
/*
삼각형의 닮음을 이용함. 이부분의 최백준님의 소스참고함.
 */
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    var (x,y,c)=br.readLine().split(" ").map { it.toDouble() }
    var left=0.0
    var right= min(x,y)
    for(i in 0 until 10000)
    {
        var mid=(left+right)/2
        var d=mid
        var h1= sqrt(x*x-d*d)
        var h2=sqrt(y*y-d*d)
        var h=(h1*h2)/(h1+h2)
        if(h>c)
            left=mid
        else
            right=mid
    }
    val df=DecimalFormat("#.###")
    df.roundingMode=RoundingMode.CEILING
    println(df.format(left))

}