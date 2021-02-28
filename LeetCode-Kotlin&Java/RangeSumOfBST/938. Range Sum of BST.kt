package RangeSumOfBST

import java.util.*


  class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
  }

class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if(root==null)
            return 0
        val q=LinkedList<TreeNode>()
        q.offer(root)
        var sum=0
        while (q.isNotEmpty()){
            var size=q.size
            while (size>0){
                val dummy=q.poll()
                when (dummy.`val`) {
                    in low..high -> sum+=dummy.`val`
                }
                when {
                    dummy.left!=null -> q.offer(dummy.left)
                }
                when {
                    dummy.right!=null -> q.offer(dummy.right)
                }
                size--
            }
        }
        return sum
    }
}