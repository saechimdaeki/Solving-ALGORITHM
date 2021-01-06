lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){IntArray(n){1000000000} }
    for(i in 0 until n){
        loop@ for(j in 0 until n){
            when (i) {
                j -> arr[i][j]=0
                else -> continue@loop
            }
        }
    }
    (0 until n).forEach { i ->
        val s=br.readLine()
        s.indices.forEach { j ->
            when {
                s[j]=='Y' -> arr[i][j]=1
            }
        }
    }
    (0 until n).forEach { k ->
        (0 until n).forEach { i ->
            (0 until n).forEach { j ->
                when {
                    arr[i][j]>arr[i][k]+arr[k][j] -> arr[i][j]=arr[i][k]+arr[k][j]
                }
            }
        }
    }
    val list= arrayListOf<Int>()
    (0 until n).forEach { i ->
        var cnt=0
        loop@ for(j in 0 until n){
            when (i) {
                j -> continue@loop
            }
            when {
                arr[i][j]<=2 -> cnt++
            }
        }
        list.add(cnt)
    }
    println("${list.max()}")
}