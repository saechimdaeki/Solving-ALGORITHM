package LeetCode94

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }


/**
 * LeetCode94. Binary Tree Inorder Traversal
 * Input root = [1,null,2,3] Output = [1,3,2]
 * Input root = [] Output = []
 * Input root = [1]  Output = [1]
 */
class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list= mutableListOf<Int>()
        inorder(root,list)
        return list
    }

    fun inorder(root: TreeNode? , list: MutableList<Int>){
        if(root==null) return
        inorder(root.left,list)
        list.add(root.`val`)
        inorder(root.right,list)
    }
}