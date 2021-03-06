private val num=IntArray(20002)
private val check=BooleanArray(20002)
private lateinit var a:Array<ArrayList<Int>>
private lateinit var arr:Array<ArrayList<Int>>
private val s=ArrayList<Int>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (m,n)=br.readLine().split(" ").map { it.toInt() }
    a=Array(2*n){ArrayList<Int>()}
    arr=Array(2*n){ArrayList<Int>() }
    repeat(m){
        val (f,t)=br.readLine().split(" ").map { it.toInt() }
        a[crop(-f,n)].add(crop(t,n))
        arr[crop(t,n)].add(crop(-f,n))
        a[crop(-t,n)].add(crop(f,n))
        arr[crop(f,n)].add(crop(-t,n))
    }
    for(i in 0 until 2*n)
        dfs(i)

    check.fill(false)
    num.fill(0)
    var cnt=0
    for(i in 2*n-1 downTo 0){
        if(!check[s[i]]){
            dfs(s[i],cnt)
            cnt++
        }
    }
    var che=true
    for(i in 0 until n){
        if(num[i]==num[2*n-i-1])
            che=false
    }
    println(if(che) "^_^" else "OTL")
}
fun dfs(x:Int){
    when {
        check[x] -> return
        else -> {
            check[x] = true
            a[x].forEach { num ->
                dfs(num)
            }
            s.add(x)
        }
    }
}
fun dfs(x:Int, cnt:Int){
    when {
        check[x] -> return
        else -> {
            check[x] = true
            num[x] = cnt
            a[x].forEach { num ->
                dfs(num, cnt)
            }
        }
    }
}
fun crop(x:Int,y:Int):Int{
    return when {
        x>0 -> x-1
        else -> 2 * y + x
    }
}