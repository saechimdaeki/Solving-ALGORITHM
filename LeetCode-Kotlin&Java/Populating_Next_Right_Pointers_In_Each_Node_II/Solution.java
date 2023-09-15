package 자바.leetcode.Populating_Next_Right_Pointers_In_Each_Node_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
class Solution {
    public Node connect(Node root) {
        dfs( root, 0, new ArrayList<>());
        return root;
    }

    public void dfs(Node node, int level, List<Node> list) {
        if (node == null) return;
        if ( level == list.size() )
            list.add(node);
        else {
            list.get(level).next = node;
            list.set(level, node);
        }
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }
}