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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        fun(root,arr);
        return arr;
    }
    public void fun(TreeNode node, ArrayList<Integer> arr){
        if(node==null) return;

        arr.add(node.val);
        fun(node.left, arr);
        fun(node.right, arr);

        

    }
}