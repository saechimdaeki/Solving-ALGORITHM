private val sadae= arrayListOf<Int>()
private val animals= arrayListOf<Pair<Int,Int>>()
fun main() {
    val br=System.`in`.bufferedReader()
    val (m,n,l)=br.readLine().split(" ").map{it.toInt()}
    br.readLine().split(" ").map{it.toInt()}.forEach{sadae.add(it)}
    sadae.sort()
    repeat(n){
        val (x,y)= br.readLine().split(" ").map {it.toInt()}
        animals.add(Pair(x,y))
    }
    animals.sortBy{it.first}
    var hunting=0
    for(i in 0 until n)
    {
        val (x,y)= animals[i]
        var left=0
        var right=m-1
        while (left<=right)
        {
            val mid=(left+right)/2
            if(isHuntingPossible(mid,x,y,l))
            {
                hunting++
                break
            }
            when {
                sadae[mid]> x-(y-l) -> right=mid-1
                else -> left=mid+1
            }
        }
    }
    println(hunting)
}
private fun isHuntingPossible(target:Int , x:Int,y:Int,l:Int):Boolean{
    return sadae[target] in x-(l-y) .. x+(l-y)
}