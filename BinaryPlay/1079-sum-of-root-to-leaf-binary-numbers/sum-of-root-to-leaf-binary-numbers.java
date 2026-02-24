/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int solve(TreeNode node , int curr){
        if(node == null) return 0;

        curr = curr * 2 + node.val;

        if(node.left == null && node.right == null) return curr;

        return solve(node.left , curr) + solve(node.right , curr);
    }
    public int sumRootToLeaf(TreeNode root) {
        return solve(root , 0);
    }
}