package 코틀린.롤케이크자르기

class Solution {
    fun solution(topping: IntArray): Int {
        var answer = 0
        val set = mutableSetOf<Int>()
        val map = mutableMapOf<Int, Int>()


        // 나 1 동생 N-1
        set.add(topping[0])
        (1 until topping.size).forEach { i ->
            map[topping[i]] = map.getOrDefault(topping[i], 0) + 1
        }


        // 동생 꺼 하나씩 빼오기
        (1 until topping.size).forEach { i ->
            set.add(topping[i])
            map[topping[i]] = map[topping[i]]!! - 1
            if (map[topping[i]] == 0)
                map.remove(topping[i])
            if (set.size == map.size)
                answer++
        }
        return answer
    }
}


fun main() {
    Solution().apply {
        println(solution(intArrayOf(1, 2, 1, 3, 1, 4, 1, 2))) // 2
        println(solution(intArrayOf(1, 2, 3, 1, 4))) // 0
    }
}