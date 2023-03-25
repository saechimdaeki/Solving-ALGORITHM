package boj20291

val bw = System.out.bufferedWriter()
fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n){ readLine()!!.split(".")[1] }
    arr.sort()
    val answerlist = mutableListOf<String>()

    var curCnt = 1
    for (i in 1 until n) {
        if (arr[i] == arr[i-1]) {
            curCnt++
        } else {
            answerlist.add("${arr[i-1]} $curCnt")
            curCnt = 1
        }
    }
    answerlist.add("${arr[n-1]} $curCnt")

    for (s in answerlist) {
        bw.write("$s\n")
    }
    bw.flush()
}