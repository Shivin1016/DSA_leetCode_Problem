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
    int max_sum;
    public int solve(TreeNode root){
        if(root == null) return 0; // no nodes in tree

        int l = solve(root.left);
        int r = solve(root.right);

        // case -1 converging part --> dono trf se accha
        int nicche_se_hi_accha_milega = l + r + root.val;

        //case 2--> ya to left se ya phir right se
        int dono_me_se_koi_ek_accha = Math.max(l , r) + root.val;

        //case 3 --> srif root hi accha
        int srif_root_hi_accha = root.val;

        max_sum = Math.max(max_sum , Math.max(nicche_se_hi_accha_milega , Math.max(dono_me_se_koi_ek_accha , srif_root_hi_accha)));

        //upper me add srif case -2 ya case 3 lenege
        return Math.max(dono_me_se_koi_ek_accha , srif_root_hi_accha);
    }

    public int maxPathSum(TreeNode root) {

        max_sum = Integer.MIN_VALUE;
        solve(root);
        return max_sum;
    }
}