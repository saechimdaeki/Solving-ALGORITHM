fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        val keyFirst=br.readLine().split(" ")
        val keySecond=br.readLine().split(" ")
        val list= arrayListOf<Int>()
        for(i in keyFirst.indices)
        {
            for(j in keySecond.indices)
            {
                if(keyFirst[i]==keySecond[j])
                    list.add(j)
            }
        }
        val sentence=br.readLine().split(" ")
        for(i in list)
        bw.write("${sentence[i]} ")
        bw.write("\n")
    }
    bw.flush()
}