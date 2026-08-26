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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        BstPair ans = ValidBST(root);
        return ans.isbst;
    }

    public BstPair ValidBST(TreeNode root) {

        // Base case
        if (root == null) {
            return new BstPair();
        }

        // Get information from left and right subtrees
        BstPair lbp = ValidBST(root.left);
        BstPair rbp = ValidBST(root.right);

        // Create pair for current subtree
        BstPair sbp = new BstPair();

        // Check whether current subtree is a BST
        sbp.isbst = lbp.isbst 
                 && rbp.isbst
                 && root.val > lbp.max
                 && root.val < rbp.min;

        // Calculate minimum and maximum of current subtree
        sbp.min = Math.min(root.val, Math.min(lbp.min, rbp.min));
        sbp.max = Math.max(root.val, Math.max(lbp.max, rbp.max));

        return sbp;
    }
}

class BstPair {
    boolean isbst = true;
    long max = Long.MIN_VALUE;
    long min = Long.MAX_VALUE;
}