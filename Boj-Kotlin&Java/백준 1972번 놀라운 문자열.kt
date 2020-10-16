package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    while (true){
        val input=br.readLine()
        if(input=="*") break
        var check=true
        var idx=1
        input.indices.forEach { _ ->
            val map= mutableMapOf<String,Int>()
            var cnt=0
            loop@ while (true){
                if(cnt+idx>=input.length) break
                val temp=input[cnt]+""+input[cnt+idx]
                when {
                    map.containsKey(temp) -> {
                        check=false
                        break@loop
                    }
                    else -> {
                        map[temp]=1
                    }
                }
                cnt++
            }
            idx++
        }
        when {
            check -> {
                bw.write("$input is surprising.\n")
            }
            else -> {
                bw.write("$input is NOT surprising.\n")
            }
        }
    }
    bw.flush()
}