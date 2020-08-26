fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val input=br.readLine().split(" ").map { it.toLong() }
    var list=Array(n){Pair<Int,Long>(0,0)}
    for(i in 0 until n)
    {
        var num=input[i]
       list[i]= list[i].copy(first = list[i].first,second = num)
        while (num%3==0L)
        {
            num/=3
            list[i]= list[i].copy(first = list[i].first+1,second = list[i].second)
        }
    }
    val comparator= compareBy<Pair<Int,Long>>{-it.first}
    val secondcomparator=comparator.thenBy { it.second }
    list=list.sortedWith(secondcomparator).toTypedArray()
    for(i in list)
        print("${i.second} ")
}