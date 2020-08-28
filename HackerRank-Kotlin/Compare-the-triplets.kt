package 해커랭크

private fun compareTriplets(a: Array<Int>, b: Array<Int>): Array<Int> {
    var (x,y)= intArrayOf(0,0)
    for(i in a.indices){
        if(a[i]<b[i])
            y++
        else if(a[i]>b[i])
            x++
    }
    val answer= intArrayOf(x,y)
    return answer.toTypedArray()
}

fun main(args: Array<String>) {
    val a = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val b = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = compareTriplets(a, b)

    println(result.joinToString(" "))
}
