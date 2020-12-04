package 백준

private lateinit var arr:IntArray
private lateinit var tree1:LongArray
private lateinit var tree2:LongArray

private fun update(tree:LongArray,idx:Int,chai:Long){
    var i= idx
    while (i<tree.size){
        tree[i]+=chai
        i+= (i and -i)
    }
}

private fun sum(tree: LongArray,idx:Int):Long{
    var ans=0L
    var i=idx
    while (i>0){
        ans+=tree[i]
        i-= (i and -i)
    }
    return ans
}

private fun sum(tree:LongArray, start:Int, end:Int):Long{
    return when {
        start>end -> 0
        else -> (sum(tree, end) - sum(tree, start - 1))
    }
}


fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()

    tree1=LongArray(n+1)
    tree2= LongArray(n+1)
    val temp= arrayListOf<Int>()
    temp.add(-1)
    val tempr=br.readLine().split(" ").map { it.toInt() }
    temp.addAll(tempr)
    arr=temp.toIntArray()
    var answer=0L
    for(i in 1..n){
        update(tree1,arr[i],1)
        update(tree2,arr[i], sum(tree1,arr[i]+1,n))
        answer+=sum(tree2,arr[i]+1,n)
    }
    println("$answer")

}