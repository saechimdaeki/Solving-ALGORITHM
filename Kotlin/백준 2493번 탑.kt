import java.util.*

fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    val arr=br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val stack= Stack<Pair<Int,Int>>()
    //기존 O(n^2)에서 시간초과났는데 아래의 풀이는 블로그이웃분의 풀이를보았습니다.. 다시공부할것.
    val answer=Array(n){0}
    for(i in 0 until n)
    {
        if(stack.empty())
            stack.push(Pair(i+1,arr[i]))
        else{
            while(stack.peek().second<arr[i])
            {
                stack.pop()
                if(stack.empty())
                    break
            }
            if(stack.isNotEmpty())
                answer[i]=stack.peek().first
            stack.push(Pair(i+1,arr[i]))
        }
    }
    for(i in 0 until n)
        print("${answer[i]} ")

}