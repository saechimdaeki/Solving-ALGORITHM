package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        var recordSound=br.readLine()
        val map= mutableMapOf<String,String>()
        while (true){
            val input=br.readLine()
            if(input=="what does the fox say?")
            {
                val tmp=recordSound.split(" ")
                for(i in tmp)
                {
                    if(!map.containsValue(i))
                        bw.write("$i ")
                }
                break
            }else{
                val tmp=input.split(" ")
                map[tmp[0]]=tmp[2]
            }
        }
    }
    bw.flush()
}