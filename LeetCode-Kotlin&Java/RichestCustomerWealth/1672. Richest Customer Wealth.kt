package RichestCustomerWealth

class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        val arr= arrayListOf<Int>()
        accounts.forEach { account ->
            arr.add(account.sum())
        }
        return arr.max()!!
    }
}