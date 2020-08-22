fun main() {
    val br=System.`in`.bufferedReader()
    val p1=br.readLine().split(" ").map { it.toInt() }
    val p2=br.readLine().split(" ").map { it.toInt() }
    val p3=br.readLine().split(" ").map { it.toInt() }
    // list의 0은 x 1은 y
    var answer=((p1[0]*p2[1]+p2[0]*p3[1]+p3[0]*p1[1])-(p1[1]*p2[0]+p2[1]*p3[0]+p3[1]*p1[0]))
    when {
        answer<0 -> println(-1)
        answer>0 -> println(1)
        else -> println(0)
    }
}