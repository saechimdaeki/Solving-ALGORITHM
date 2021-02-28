package ConvertBinaryNumberInALinkedListToInteger



  class ListNode(var `val`: Int) {
      var next: ListNode? = null
  }

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        val s= StringBuilder()
        s.append(head!!.`val`)
        var now= head
        while (now!!.next!=null){
            now=now.next
            s.append(now!!.`val`)
        }
        val number=s.toString()
        return number.toInt(2)
    }
}