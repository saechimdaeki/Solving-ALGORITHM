fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    var answer=0
    var (n,m)=br.readLine().split(" ").map { it.toInt() }
    val list=ArrayList<String>()
    while (n-- >0)
        list.add(br.readLine())
    while(m-->0)
    {
        val input=br.readLine()

        loopfor@for(i in list)
        {
            if(i.startsWith(input))
            {
                answer++
                break@loopfor
            }
        }
    }
    println(answer)
}