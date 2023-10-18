package 자바.leetcode.LeetCode623;

public class TreeNode {
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

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return depth == 1 ? new TreeNode(val, root, null) : dfs(root, val, depth, 1);
    }
    private TreeNode dfs(TreeNode node, int val, int depth, int level) {
        if (node == null) return null;
        if (depth == level + 1) {
            node.left = new TreeNode(val, node.left, null);
            node.right = new TreeNode(val, null, node.right);
        } else {
            node.left = dfs(node.left, val, depth, level+1);
            node.right = dfs(node.right, val, depth, level+1);
        }
        return node;
    }
}