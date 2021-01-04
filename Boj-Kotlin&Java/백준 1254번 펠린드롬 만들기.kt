import kotlin.system.exitProcess
var s=""
fun main() {
    s= readLine()!!
    s.indices.forEach { i ->
        when {
            istrue(i,s.length) -> {
                println(s.length+i)
                exitProcess(0)
            }
        }
    }
}
private fun istrue(idx:Int, leng:Int):Boolean{
    (0 until (leng-idx)/2).forEach { i ->
        when {
            s[idx+i]!=s[leng-1-i] -> return false
        }
    }
    return true
}