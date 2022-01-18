package LeetCode204

/* 204. Count Primes */
class Solution {
    fun countPrimes(n: Int): Int {

        val list= mutableListOf<Int>()
        val prime=BooleanArray(n+1){true}
        if(n<=2) return 0
        prime[0]=false
        prime[1]=false

        (2 until n)
            .asSequence()
            .filter { prime[it] }
            .flatMap { (it *2 until n step it).asSequence() }
            .forEach { prime[it]=false }
        (0 until n).filterTo(list) { prime[it] }

        return list.size
    }
}