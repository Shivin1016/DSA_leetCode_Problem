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
    int maxPath;
    public int solve(TreeNode root){
        if(root == null) return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        int below_part = l + r + 1;
        int left_ya_right = Math.max(l , r) + 1;
        int only_node = 1;

        maxPath = IntStream.of(maxPath , below_part , left_ya_right , only_node).max().getAsInt();

        return Math.max(left_ya_right , only_node);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        solve(root);

        return maxPath - 1; // as my code count each node , so path will be maxPath - 1;
    }
}