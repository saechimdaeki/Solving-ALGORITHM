package 백준

fun main() {
    val g= readLine()!!.toInt()
    val answer= arrayListOf<Int>()
    var (start,end)= arrayOf(1,1)
    //100001
    loop@ while (true){
        when {
            end>=100001 -> break@loop
        }
        when (g) {
            end*end-start*start -> answer.add(end)
        }
        when {
            end*end-start*start<=g -> end++
            end*end-start*start>g -> start++
        }
    }
    when (answer.size) {
        0 -> println(-1)
        else -> {
            answer.sort()
            for(i in answer)
                println("$i")
        }
    }
}