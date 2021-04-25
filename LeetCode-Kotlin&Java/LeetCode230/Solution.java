package LeetCode230;

import java.util.ArrayList;
import java.util.Collections;

/* 230. Kth Smallest Element in a BST */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static ArrayList<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        dfs(root);
      //  Collections.sort(list);
        return list.get(k-1);
    }

    static void dfs(TreeNode root){
        if(root==null)  return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
