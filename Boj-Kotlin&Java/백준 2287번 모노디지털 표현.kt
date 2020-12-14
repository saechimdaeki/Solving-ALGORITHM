package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val arr=Array(9){HashSet<Int>()}
    var num=0
    val k =br.readLine().toInt()
    (1..8).forEach { i ->
        num=(num*10+k)
        arr[i].add(num)
    }
    (2..8).forEach { i ->
        (1 until i).forEach { j ->
            val tmp=i-j
            arr[j].forEach { x ->
                arr[tmp].forEach { y ->
                    arr[i].add(x+y)
                    arr[i].add(x-y)
                    arr[i].add(x*y)
                    when {
                        y!=0 -> arr[i].add(x/y)
                    }
                }
            }
        }
    }
    val n=br.readLine().toInt()
    repeat(n){
        val temp=br.readLine().toInt()
        var check=false
        loop@ for(i in 1..8){
            when {
                arr[i].contains(temp) -> {
                    bw.write("$i\n")
                    check=true
                    break@loop
                }
            }
        }
        when {
            !check -> bw.write("NO\n")
        }
    }
    bw.flush()
}