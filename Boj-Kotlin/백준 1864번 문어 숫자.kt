import kotlin.math.pow

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val map= hashMapOf<Char,Int>()
    map['-']=0
    map['\\']=1
    map['(']=2
    map['@']=3
    map['?']=4
    map['>']=5
    map['&']=6
    map['%']=7
    map['/']=-1
    while (true)
    {
        val input=br.readLine()
        var cnt=input.length-1
        var answer=0
        if(input == "#")
            break

        for(i in input.indices)
        {
            answer+= map[input[i]]!!*((8.0).pow(cnt).toInt())
            cnt--
        }
        bw.write("${answer}\n")
    }
    bw.flush()
}