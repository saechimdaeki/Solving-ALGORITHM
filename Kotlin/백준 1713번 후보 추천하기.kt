fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val m=br.readLine().toInt()
    val input=br.readLine().split(" ").map { it.toInt() }
    val arr=ArrayList<Pair<Int,Int>>()
    val choochun=Array(101){0}
    for(i in 0 until n)
        arr.add(Pair(0,0))
    for(i in 0 until m)
    {
        choochun[input[i]]++
        var replace=true
        for(j in 0 until n)
        {
            if(arr[j].second==0)
            {
                arr[j]=arr[j].copy(second = input[i],first = i)
                replace=false
                break
            }else if(arr[j].second==input[i])
            {
                replace=false
                break

            }
        }
        if(replace)
        {
            var idx=0
            for(j in 1 until n)
            {
                if(choochun[arr[j].second]==choochun[arr[idx].second])
                {
                    if(arr[j].first<arr[idx].first)
                        idx=j
                }else if (choochun[arr[j].second]<choochun[arr[idx].second])
                    idx=j
            }
            choochun[arr[idx].second]=0
            arr[idx]=arr[idx].copy(first = i,second = input[i])
        }
    }
    val answerlist= arrayListOf<Int>()
    for(i in 0 until n)
        answerlist.add(arr[i].second)
    answerlist.sort()
    for (i in answerlist)
        print("$i ")

}