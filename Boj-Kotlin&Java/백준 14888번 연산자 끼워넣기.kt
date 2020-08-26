private val arraylist= arrayListOf<Int>()
private lateinit var arr:List<Int>
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    arr = br.readLine().split(" ").map { it.toInt() }
    val (pl, mi, mu, di) = br.readLine().split(" ").map { it.toInt() } //+ - * /
    search(1,pl,mi,mu,di,n,arr[0])
    println(arraylist.max())
    println(arraylist.min())
}
private fun search(i:Int,pl:Int,mi:Int,mu:Int,di:Int,n:Int,sum:Int){
    if(i==n)
        arraylist.add(sum)
    if(pl>0)
        search(i+1,pl-1,mi,mu,di,n,sum+arr[i])
    if(mi>0)
        search(i+1,pl,mi-1,mu,di,n,sum-arr[i])
    if(mu>0)
        search(i+1,pl,mi,mu-1,di,n,sum*arr[i])
    if(di>0)
        search(i+1,pl,mi,mu,di-1,n,sum/arr[i])
}
