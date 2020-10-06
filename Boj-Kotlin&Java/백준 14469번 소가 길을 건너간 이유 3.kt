package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr= arrayListOf<Pair<Int,Int>>()
    repeat(n){
        val (a,b)=br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(a,b))
    }
    val firstComp= compareBy<Pair<Int,Int>> { it.first }
    val secondComp=firstComp.thenBy { it.second }
    arr.sortWith(secondComp)
    var answer=arr[0].first+arr[0].second
    for(i in 1 until n){
        if(answer>arr[i].first)
            answer+=arr[i].second
        else
            answer=arr[i].first+arr[i].second
    }
    println(answer)
}