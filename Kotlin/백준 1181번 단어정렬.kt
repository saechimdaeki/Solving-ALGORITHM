package boj14681kot

fun main(args:Array<String>) {
    val br=System.`in`.bufferedReader()
    val s = HashSet<String>()
    val n=br.readLine().toInt()
    for (i in 0 until n) {
        s.add(br.readLine())
    }
    val list = s.toMutableList()
    list.sort()
    list.sortBy { it->it.length}
    for (i in list) {
        println(i)
    }
}