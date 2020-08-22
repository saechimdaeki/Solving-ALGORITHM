fun main() {
    val (MIN,MAX)=System.`in`.bufferedReader().readLine().split(" ").map {it.toLong()}
    val visited=Array((MAX-MIN).toInt()+1){false}
    run{
        var i=2L
        while (i*i<=MAX){
            var w= i*i-MIN%(i*i)
            if(w==i*i)
                w=0
            while (w<=MAX-MIN)
            {
                visited[w.toInt()]=true
                w+=i*i
            }
            i++
        }
    }
    var answer=0
    for(i in 0 .. MAX-MIN)
    {
        if(!visited[i.toInt()])
            answer++
    }
    println(answer)
}