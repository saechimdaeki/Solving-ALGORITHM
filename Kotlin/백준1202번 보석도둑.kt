package boj14681kot

import java.util.*

private class jewel :Comparable<jewel>{
    var moogae=0
    var value=0
    constructor(moogae:Int, value:Int){
        this.moogae=moogae
        this.value=value
    }
     override fun compareTo(other: jewel): Int {
         return when {
             this.value>other.value -> -1
             this.value==other.value -> 0
             else -> 1
         }
    }
}
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map { it.toInt() }
    val jewelarray=Array(n){jewel(0,0)}
    for(i in 0 until n)
    {
        val (tmp1, tmp2)=br.readLine().split(" ").map { it.toInt() }
        jewelarray[i]= jewel(tmp1,tmp2)
    }
    jewelarray.sort()
    val map=TreeMap<Int,Int>()
    /* map[something] = 최대무게가 something인 것의 갯수 */
    for(i in 0 until k)
    {
        val tmp=br.readLine().toInt()
        var tmp2= map[tmp]
        if(tmp2==null)
            tmp2=0
        tmp2++
        map[tmp] = tmp2
    }
    var answer=0L
    for(i in 0 until n)
    {
        val abcd=map.ceilingEntry(jewelarray[i].moogae)
        /* jewelarray[i]와 키가같거나 이것보다 큰키중 가장작은 값에 대응하는 entry가 abcd */
        if(abcd!=null)
        {
            answer+=jewelarray[i].value
            val c=abcd.key
            val value=abcd.value-1
            if(value==0)
                map.remove(c)
            else
                map[c] = value
        }
    }
    println(answer)
}


