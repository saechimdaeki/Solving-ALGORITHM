fun main(args: Array<String>) {
    val br=System.`in`.bufferedReader()
    var answer=0
    var (n,m)=br.readLine().split(" ").map { it.toInt() }
    val trie=trie14426()
    while (n-- >0)
        trie.add(br.readLine())
    while(m-->0)
    {
        if(trie.search(br.readLine()))
            answer++
    }
    println(answer)
}
private class trie14426() {
    inner class Node {
        var children=IntArray(26){-1}
        var valid=false
    }
    var trie: ArrayList<Node>
    var root: Int
    fun init(): Int {
        val x = Node()
        trie.add(x)
        return trie.size - 1
    }
    fun add(node: Int, s: String, index: Int) {
        if (index == s.length) {
            trie[node].valid = true
            return
        }
        val c = s[index] - 'a'
        if (trie[node].children[c] == -1) {
            val next = init()
            trie[node].children[c] = next
        }
        val child = trie[node].children[c]
        add(child, s, index + 1)
    }
    fun add(s: String) {
        add(root, s, 0)
    }
    fun search(node: Int, s: String, index: Int): Boolean {
        if (node == -1) return false
        if (index == s.length) return true
        val c = s[index] - 'a'
        val child = trie[node].children[c]
        return search(child, s, index + 1)
    }
    fun search(s: String): Boolean {
        return search(root, s, 0)
    }
    init {
        trie = ArrayList()
        root = init()
    }
}