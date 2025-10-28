import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(res, root, 0);
        return res;
    }

    void dfs(List<Integer> res, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(node.val);
        }
        dfs(res, node.right, depth + 1);
        dfs(res, node.left, depth + 1);
    }
}