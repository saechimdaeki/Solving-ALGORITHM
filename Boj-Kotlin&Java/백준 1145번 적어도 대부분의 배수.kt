fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val arr=br.readLine().split(" ").map {it.toInt()}.sorted()
    var JungJoongWang=arr[2]
    var cnt=0
    loopwhile@while (true)
    {
        for(i in arr.indices)
        {
            if(JungJoongWang%arr[i]==0)
                cnt++
        }
        if(cnt>2)
            break@loopwhile
        cnt=0
        JungJoongWang++
    }
    println(JungJoongWang)

}