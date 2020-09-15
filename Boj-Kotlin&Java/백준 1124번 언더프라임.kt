package 백준

fun main() {
    val (a,b)= readLine()!!.split(" ").map { it.toInt() }
    val visited=BooleanArray(100000)
    visited[1]=true
    for(i in 2 until 100000){
        if(visited[i]) continue
        for(j in 2*i until 100000 step i)
            visited[j]=true
    }
    var answer=0
    for(i in a .. b) {
        val list = arrayListOf<Int>()
        var tmp = i
        var k = 2
        while (tmp != 1) {
            if (tmp % k == 0) {
                if (!visited[k]) list.add(k)
                tmp /= k
            } else k++
        }
        if (!visited[list.size]) {
            //println(i)
            answer++
        }
    }
    println("$answer")
}