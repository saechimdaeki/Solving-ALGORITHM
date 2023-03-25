package boj2805

var answer = 0L
lateinit var trees : LongArray
fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toLong() }
    trees = readLine()!!.split(" ").map { it.toLong() }.sorted().toLongArray()

    var left = 1L
    var right = trees.last()

    while (left<=right) {
        val mid = (left+right)/2
        if(possible(mid, m)) {
            answer = maxOf(answer , mid)
            left = mid+1
        }else {
            right = mid-1
        }
    }
    println(answer)
}

fun possible(mid: Long, m : Long) : Boolean {
    var sum = 0L
    for(i in trees.indices) {
        if(trees[i] > mid ) {
            sum += (trees[i] - mid)
        }
    }
    return sum >= m
}