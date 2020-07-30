fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    var map= mutableMapOf<String,Int>()
    for(i in 0 until n)
    {
        val input=br.readLine()
        if(map.containsKey(input))
            map[input] = map[input]!!+1
        else
            map[input]=1
    }
    for(i in 0 until n-1)
    {
        val input=br.readLine()
        map[input]=map[input]!!-1
    }
    for(i in map)
    {
        if(i.value==1)
            println(i.key)
    }
}