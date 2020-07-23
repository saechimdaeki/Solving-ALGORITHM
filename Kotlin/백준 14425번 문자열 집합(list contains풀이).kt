private var answer=0
fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,m)=br.readLine().split(" ").map { it.toInt() }
    val list=ArrayList<String>()
    for(i in 0 until n)
        list.add(br.readLine())
    for(i in 0 until m)
    {
        if(list.contains(br.readLine()))
            answer++
    }
    println(answer)
}