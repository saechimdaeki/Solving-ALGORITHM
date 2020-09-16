package 백준
private lateinit var arr:Array<IntArray>
fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val n=br.readLine().toInt()
    arr=Array(27){IntArray(27){1000000000}}
    for(i in 1..26){
        for(j in 1..26)
            if(i==j) arr[i][j]=0
    }
    repeat(n){
        val s=br.readLine().split(" ")
        //println((s[0][0]-96).toInt())
        arr[(s[0][0]-96).toInt()][(s[2][0]-96).toInt()]=1
    }
    for(k in 1..26){
        for(i in 1..26){
            for(j in 1..26){
                if(arr[i][j]>arr[i][k]+arr[k][j])
                    arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }
    val m=br.readLine().toInt()
    repeat(m){
        val s=br.readLine().split(" ")
        if(arr[(s[0][0]-96).toInt()][(s[2][0]-96).toInt()]==1000000000 ||arr[(s[0][0]-96).toInt()][(s[2][0]-96).toInt()]==0)
            bw.write("F\n")
        else
            bw.write("T\n")
        //println("${(s[0][0]-96).toInt()} ${(s[2][0]-96).toInt()}")
    }
    bw.flush()
}