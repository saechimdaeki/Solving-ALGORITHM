package 코틀린.programmers.다단계_칫솔_판매

class Solution {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val map = mutableMapOf<String, Node>()
        enroll.forEach {  map[it] = Node(name = it) }

        map["-"] = Node("-")

        for (i in referral.indices) {
            val s = referral[i]
            map[enroll[i]]!!.recommender = map[s]
        }

        seller.indices.forEach { i ->
            val sellerTmp = seller[i]
            val amountTmp = amount[i] * 100 // 개당 100원.
            calc(map[sellerTmp]!!, amountTmp)
        }

        enroll.mapTo(answer) { map[it]!!.amount }

        return answer.toIntArray()
    }

    fun calc(node: Node , amount: Int) {
        val amountDadan = amount/10
        if (node.recommender != null && amountDadan != 0) {
            node.amount += (amount - amountDadan)
            calc(node.recommender!! , amountDadan)
        } else
            node.amount += amount
    }

}

data class Node (
    var name : String,
    var recommender : Node? = null,
    var amount : Int = 0

)

fun main() {
    Solution().apply {
        val solution1 = solution(
            arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"),
            arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"),
            arrayOf("young", "john", "tod", "emily", "mary"),
            intArrayOf(12, 4, 2, 5, 10)
        )

        println(solution1.contentToString()) // 360, 958, 108, 0, 450, 18, 180, 1080

        val solution2 = solution(
            arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"),
            arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"),
            arrayOf("sam", "emily", "jaimie", "edward"),
            intArrayOf(2, 3, 5, 4)
        )

        println(solution2.contentToString()) // 0, 110, 378, 180, 270, 450, 0, 0
    }
}