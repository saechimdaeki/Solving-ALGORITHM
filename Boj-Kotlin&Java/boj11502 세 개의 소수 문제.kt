package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    var t=br.readLine().toInt()
    val arr=BooleanArray(1001)
    for(i in 2 .. 1000){
        if(arr[i]) continue
        for(j in i+i ..1000 step i)
            arr[j]=true
    }
    loop@while (t-->0){
        val tmp=br.readLine().toInt()
        for(i in 2..tmp){
            for(j in 2..tmp){
                for(k in 2..tmp){
                    if(arr[i]||arr[j]||arr[k]) continue
                    if(i+j+k ==tmp) {
                        bw.write("$i $j $k\n")
                        continue@loop
                    }
                }
            }
        }
    }
    bw.flush()
}