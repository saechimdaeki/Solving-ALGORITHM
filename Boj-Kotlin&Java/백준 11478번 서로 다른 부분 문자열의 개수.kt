package 백준

fun main() {
    val s= readLine()!!
    val set= mutableSetOf<String>()
    for(i in s.indices){
        var tmp=""
        for(j in i until s.length){
            tmp+=s[j]
            set.add(tmp)
        }
    }
    println(set.size)
}