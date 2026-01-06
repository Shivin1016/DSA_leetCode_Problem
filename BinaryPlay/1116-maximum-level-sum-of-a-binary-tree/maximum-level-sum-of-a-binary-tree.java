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
    public int maxLevelSum(TreeNode root) {
        long maxSum = Long.MIN_VALUE;
        int level = 1; // ans

        int l = 1;

        var que = new LinkedList<TreeNode>();
        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            long sum = 0;
            while(size-- > 0){
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
            if(maxSum < sum){
                maxSum = sum;
                level = l;
            }
            l++;
        }

        return level;


    }
}