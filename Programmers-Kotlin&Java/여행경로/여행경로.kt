package 프로그래머스.여행경로

class Solution {
    lateinit var visited:BooleanArray
    val list= arrayListOf<String>()
    var bridge=""
    fun solution(tickets: Array<Array<String>>): Array<String> {
        visited= BooleanArray(tickets.size)
        for(i in tickets.indices){
            if(tickets[i][0]=="ICN"){
                visited[i]=true
                bridge=tickets[i][0]+","
                dfs(tickets,tickets[i][1],1)
                visited[i]=false
            }
        }
       // for(i in list)
      //     println("$i ")
        list.sort()
        //for(i in list)
       //     println("$i ")
       // println("=====================")
        var answer=list[0].split(",")
        answer=answer.subList(0,answer.size-1)
        return answer.toTypedArray()

    }
    fun dfs(tickets: Array<Array<String>>, desti:String, cnt:Int){
        bridge+= "$desti,"
        if(cnt==tickets.size){
            list.add(bridge)
            return
        }
        for(i in tickets.indices){
            if(desti == tickets[i][0] &&!visited[i]){
                visited[i]=true
                dfs(tickets,tickets[i][1],cnt+1)
                visited[i]=false
                bridge=bridge.substring(0,bridge.length-4)
            }
        }
    }
}

fun main() {
    val s=Solution()
    val tmp=s.solution(arrayOf(arrayOf("ICN","JFK"), arrayOf("HND","IAD"), arrayOf("JFK","HND")))
    for(i in tmp)
        print("$i ")
    println()
   // val tmp2=s.solution(arrayOf(arrayOf("ICN","SFO"), arrayOf("ICN","ATL"), arrayOf("SFO","ATL"), arrayOf("ATL","ICN"), arrayOf("ATL,SFO")))
   // for(i in tmp2)
    //    print("$i ")
}