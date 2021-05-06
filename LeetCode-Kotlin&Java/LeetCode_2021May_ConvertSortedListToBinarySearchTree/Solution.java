package LeetCode_2021May_ConvertSortedListToBinarySearchTree;


import java.util.ArrayList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }




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

class Solution {
        ArrayList<Integer> list;
      public TreeNode sortedListToBST(ListNode head) {
        /* bst */
          list=new ArrayList<>();
          while (head!=null){
              list.add(head.val);
              head=head.next;
          }
        return bst(0,list.size());

      }
    private TreeNode bst(int left, int right){
          if(left>right) return null;
          int mid=(left+right)/2;
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left=bst(left,mid-1);
        treeNode.right=bst(mid+1,right);
        return treeNode;
    }
}
