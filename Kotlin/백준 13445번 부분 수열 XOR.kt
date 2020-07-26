fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    val (n,k)=br.readLine().split(" ").map{it.toInt()}
    val arr=br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    val trie=Trie13445()
    trie.add(0)
    var jupmisa=0
    var answer=0L
    for(i in 0 until n)
    {
        jupmisa=jupmisa xor arr[i]
        answer+=trie.search(jupmisa,k)
        trie.add(jupmisa)
    }
    println("$answer")
}
private class Trie13445{
    inner class Node{
        val child=IntArray(2){-1}
        var valid=false
        val cnt=IntArray(2){0}
    }
    var root=0
    val list= arrayListOf<Node>()
    init{
        root=init()
    }
    fun init():Int{
        val x=Node()
        list.add(x)
        return list.size-1
    }
    fun add(node:Int,n:Int,bit:Int){
        if (bit==-1)
        {
            list[node].valid=true
            return
        }
        val c= (n shr bit) and 1
        if(list[node].child[c]==-1)
            list[node].child[c]=init()
        list[node].cnt[c]++
        add(list[node].child[c],n,bit-1)
    }
    fun add(n:Int){
        add(root,n,20)
    }
    fun search(node:Int,n:Int,k:Int,bit:Int):Int{
        var ans=0
        if(bit==-1)
            return 0
        var c = k shr bit and 1
        var c2= n shr bit and 1
        if(c==1)
        {
            ans+=list[node].cnt[c2]
            c2=1-c2
        }
        if(list[node].child[c2]==-1)
            return ans
        ans+=search(list[node].child[c2],n, k, bit-1)
        return ans

    }
    fun search(n:Int,k:Int):Int{
        return search(root,n,k,20)
    }
}