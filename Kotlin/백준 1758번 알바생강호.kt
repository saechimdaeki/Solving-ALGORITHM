private lateinit var arr:Array<Int>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){0}
    for(i in 0 until n)
        arr[i]=br.readLine().toInt()
    var tip=0L
    arr.sortDescending()
    for(i in 0 until n)
    {
        if(arr[i]-i<=0)
            break
        tip+=arr[i]-(i)
    }
    println(tip)
}