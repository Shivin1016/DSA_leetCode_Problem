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
    public boolean solve(TreeNode root , HashSet<Integer> set , int k){

        if(root == null) return false;  

        int target = k - root.val ;

        if(set.contains(target)) return true;

        set.add(root.val);

        return solve(root.left , set , k) || solve(root.right , set , k);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return solve(root , set , k);
    }
}