package LeetCode104;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
}
/* 104. Maximum Depth of Binary Tree */
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root,0);
    }
    static int dfs(TreeNode root, int depth){
        if(root==null) return 0;
        return Math.max(dfs(root.left,depth+1),dfs(root.right,depth+1))+1;
    }
}