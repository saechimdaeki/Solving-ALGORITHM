package LeetCode1338

class Solution {
    fun minSetSize(arr: IntArray): Int {
        var answer=0
        val map= mutableMapOf<Int,Int>()
        arr.indices.forEach { i ->
            map[arr[i]]=map.getOrDefault(arr[i],0)+1
        }
        val temp=IntArray(map.size)
        var idx=0
        for(i in map.values) temp[idx++]=i
        var end=arr.size
        temp.sort()
        for(i in temp.size-1 downTo 0){
            end-=temp[i]
            answer++
            if(end<=arr.size/2) return answer
        }
        return answer
    }
}