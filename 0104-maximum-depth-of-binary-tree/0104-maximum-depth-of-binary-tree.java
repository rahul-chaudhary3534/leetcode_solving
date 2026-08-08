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
    public int maxDepth(TreeNode root) {

        return maxi(root);
        
    }
    public int maxi(TreeNode root){
        if(root==null) return 0;
        int left = maxi(root.left);
        int right = maxi(root.right);

        return Math.max(left, right) + 1;
    }
}