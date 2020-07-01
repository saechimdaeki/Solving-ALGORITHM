package boj14681kot

private var cnt=1
private var n=0
private var list=ArrayList<Int>()
private lateinit var arr:IntArray
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    n=br.readLine().toInt()
    arr=br.readLine().split(" ").map { it->it.toInt() }.toIntArray()
    val (plus, minus, mul, div)=br.readLine().split(" ").map { it->it.toInt() }
    val start=arr[0]
    dfs(cnt,plus, minus,mul,div,start)
    println(list.max())
    println(list.min())
}
private fun dfs(ct:Int,plus:Int,minus:Int,mul:Int,div:Int,sum:Int){
    if(ct==n) {
        list.add(sum)
    }
    if(plus>0)
        dfs(ct+1,plus-1,minus,mul,div, sum+arr[ct])
    if(minus>0)
         dfs(ct+1,plus,minus-1,mul,div, sum-arr[ct])
    if(mul>0)
         dfs(ct+1,plus,minus,mul-1,div, sum*arr[ct])
    if(div>0)
         dfs(ct+1,plus,minus,mul,div-1, sum/arr[ct])
}