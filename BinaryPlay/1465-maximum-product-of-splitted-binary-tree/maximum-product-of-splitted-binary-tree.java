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
    long totalSum = 0;
    long maxProduct = 0;
    long MOD = 1000_000_007;
    public long solveSum(TreeNode root){
        if(root == null) return 0;

        return root.val + solveSum(root.left) + solveSum(root.right);
    }

    // find currrent subtreesum
    public long solve(TreeNode node){
        if(node == null) return 0;

        // current subTreeSum
        long currSubTreeSum = node.val + solve(node.left) + solve(node.right);
        // another subtree sum
        long anotherSubTreeSum = totalSum - currSubTreeSum;

        //update maxProduct
        maxProduct = Math.max(maxProduct , currSubTreeSum * anotherSubTreeSum);

        return currSubTreeSum;
    }

    public int maxProduct(TreeNode root) {
        // total sum 
        totalSum = solveSum(root);
        // call solve for maxProduct
        solve(root);

        return (int)(maxProduct % MOD);
    }
}