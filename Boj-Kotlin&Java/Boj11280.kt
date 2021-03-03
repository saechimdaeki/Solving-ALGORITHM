
import java.util.ArrayList


private lateinit var a:Array<ArrayList<Int>>
private lateinit var arr:Array<ArrayList<Int>>
private val ss= arrayListOf<Int>()
private val num=IntArray(20002)
private val visited=BooleanArray(20002)
fun main() {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    a=Array(2*n){ArrayList<Int>()}
    arr=Array(2*n){ArrayList<Int>()}
    repeat(m){
        val (from,to)=br.readLine().split(" ").map { it.toInt() }
        a[abc(-from, n)].add(abc(to, n))
        arr[abc(to, n)].add(abc(-from, n))
        a[abc(-to, n)].add(abc(from, n))
        arr[abc(from, n)].add(abc(-to, n))
    }
    (0 until 2*n).forEach { i ->
        dfs(a,i)
    }
    visited.fill(false)
    (2*n-1 downTo 0)
        .asSequence()
        .filterNot { visited[ss[it]] }
        .forEachIndexed { cnt, i -> dfs(arr,ss[i],cnt) }
    val check= (0 until n).none { num[it]==num[2*n- it -1] }
    println(if(check) 1 else 0)
}
private fun abc(x:Int,n:Int):Int{
    return when {
        x>0 -> x-1
        else -> 2*n+x
    }
}

fun dfs(a: Array<ArrayList<Int>>, x: Int) {
    when {
        visited[x] -> {
            return
        }
        else -> {
            visited[x] = true
            a[x].forEach { next ->
                dfs(a, next)
            }
            ss.add(x)
        }
    }
}

private fun dfs(a: Array<ArrayList<Int>>, x: Int, cnt: Int) {
    when {
        visited[x] -> {
            return
        }
        else -> {
            visited[x] = true
            num[x] = cnt
            a[x].forEach { next ->
                dfs(a, next, cnt)
            }
        }
    }
}