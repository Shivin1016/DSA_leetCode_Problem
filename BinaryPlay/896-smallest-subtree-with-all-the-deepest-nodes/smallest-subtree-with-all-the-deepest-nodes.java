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
    Map<TreeNode , Integer> mp;
    int maxDepth = 0;

    private void depthFind(TreeNode node , int depth){
        if(node == null) return ;

        mp.put(node , depth);
        maxDepth = Math.max(maxDepth , depth);

        depthFind(node.left , depth + 1);
        depthFind(node.right , depth + 1);
    }

    private TreeNode LCA(TreeNode node){
        if(node == null || mp.get(node) == maxDepth) return node;

        TreeNode left = LCA(node.left);
        TreeNode right = LCA(node.right);

        if(left != null && right != null) return node; //LCA

        if(left != null) return left;

        return right;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        mp = new HashMap<>();
        
        // find depth for each node
        depthFind(root , 0); 

        // find the LCA 
        return LCA(root);
    }
}