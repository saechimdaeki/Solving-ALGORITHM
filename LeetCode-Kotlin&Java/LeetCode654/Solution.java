package LeetCode654;


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
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    public TreeNode dfs(int[] nums, int s, int e){
        if(s>e) return null;
        int index=-1;
        int max=-987654321;
        for(int i=s; i<=e; i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(nums[index]);
        root.left=dfs(nums,s,index-1);
        root.right=dfs(nums,index+1,e);
        return root;
    }
}