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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> arr = new ArrayList<>();

        if (root == null)
            return arr;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            List<Integer> x = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode r = q.poll();

                x.add(r.val);

                if (r.left != null)
                    q.add(r.left);

                if (r.right != null)
                    q.add(r.right);
            }

            arr.add(x);
        }

        return arr;
    }
}