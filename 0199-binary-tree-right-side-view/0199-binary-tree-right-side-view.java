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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rView = new ArrayList<>();

        if (root == null) {
            return rView;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);        

        while (queue.size() > 0) {
            int size = queue.size();

            while (size > 0) {
                TreeNode removeNode = queue.remove();

                if (size == 1) {
                    rView.add(removeNode.val);
                }

                if (removeNode.left != null) {
                    queue.add(removeNode.left);
                }
                if (removeNode.right != null) {
                    queue.add(removeNode.right);
                }
                size--;
            }
        }

        return rView;
    }
}