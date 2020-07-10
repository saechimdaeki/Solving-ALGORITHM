fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val list=ArrayList<Int>()
    for(i in 0 until n)
        list.add(br.readLine().toInt())
    list.sort()
    for(i in list)
        println(i)
}