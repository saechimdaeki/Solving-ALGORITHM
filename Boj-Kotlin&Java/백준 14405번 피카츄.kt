package 백준

import kotlin.system.exitProcess

fun main() {
    var s= readLine()!!
    while (true){
       if(s.isEmpty()) break
        s = when {
            s.startsWith("pi")|| s.startsWith("ka") -> s.substring(2,s.length)
            s.startsWith("chu") -> s.substring(3,s.length)
            else ->{
                print("NO")
                exitProcess(0)
            }
        }
    }
    print("YES")
}