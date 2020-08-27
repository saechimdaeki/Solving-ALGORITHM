package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
       bw.write("${recur(0,br.readLine().toInt())}\n")
    }
    bw.flush()
}
private fun recur(sum:Int,target:Int):Int{
    return when {
        sum>target -> 0
        sum==target -> 1
        else -> {
            var nownum = 0
            for (i in 1..3) {
                nownum += recur(sum + i, target)
            }
            nownum
        }
    }
}
