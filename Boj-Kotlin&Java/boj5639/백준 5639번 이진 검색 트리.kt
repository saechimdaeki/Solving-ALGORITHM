package boj5639

val tree = mutableListOf<Int>()
fun main() {
    while(true) {
        try {
            val input = readLine()!!.toInt()
            tree.add(input)
        } catch (e: Exception) {
            break
        }
    }
    postOrder(0, tree.size-1)
}

fun postOrder(start: Int, end: Int) {
    if(start > end) return
    var mid = end
    for (i in start+1 .. end) {
        if(tree[i]>tree[start]){
            mid = i-1
            break
        }
    }
    postOrder(start+1, mid)
    postOrder(mid+1, end)
    println(tree[start])
}