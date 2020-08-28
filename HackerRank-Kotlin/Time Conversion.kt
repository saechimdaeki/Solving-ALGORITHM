package 해커랭크

import java.util.*

fun timeConversion(s: String): String {
    /*
     * Write your code here.
    */
    val ss=s.split(":")
    var h=""
    h = if(ss[2].substring(2,ss[2].length)=="PM"){
        when {
            ss[0].toInt()<12 -> (ss[0].toInt()+12).toString()
            else -> ss[0]
        }
    }
    else {
        when {
            ss[0].toInt()==12 -> "00"
            else -> ss[0]
        }
    }
    val m=ss[1]
    val sec=ss[2].substring(0,2)
    return "$h:$m:$sec"

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}
