package LeetCode2418

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val list = names.indices.map { Pair(names[it], heights[it]) }
        val sortedWith = list.sortedWith(compareBy { -it.second })

        return sortedWith.map { it.first }.toTypedArray()
    }
}

fun main() {
    Solution().apply {
        val sortPeople = this.sortPeople(arrayOf("Mary", "John", "Emma"), intArrayOf(180, 165, 170))
        for (sortPerson in sortPeople) {
            print("$sortPerson ")
        }
        println()
        val sortPeople1 = this.sortPeople(arrayOf("Alice", "Bob", "Bob"), intArrayOf(155, 185, 150))
        for (sortPerson in sortPeople1) {
            print("$sortPerson ")
        }
        println()
    }
}