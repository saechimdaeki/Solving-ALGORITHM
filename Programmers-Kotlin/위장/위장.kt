package 메인디렉.위장

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map= hashMapOf<String,Int>()
        for(i in clothes.indices)
        {
            if(!map.containsKey(clothes[i][1]))
                map[clothes[i][1]] = 1
            else
                map[clothes[i][1]] = map[clothes[i][1]]!! +1
        }
        for(i in map.keys)
            answer*= map[i]!!+1
        return answer-1
    }
}

fun main() {
    val s=Solution()
    val arr1=Array(3){ arrayOf("")}
    val arr2=Array(3){ arrayOf("")}
    arr1[0]= arrayOf("yellow_hat", "headgear")
    arr1[1]= arrayOf("blue_sunglasses","eyewear")
    arr1[2]= arrayOf("green_turban","headgear")
    arr2[0]= arrayOf("crow_mask","face")
    arr2[1]= arrayOf("blue_sunglasses","face")
    arr2[2]= arrayOf("smoky_makeup","face")
    println(s.solution(arr1))
    println(s.solution(arr2))

}