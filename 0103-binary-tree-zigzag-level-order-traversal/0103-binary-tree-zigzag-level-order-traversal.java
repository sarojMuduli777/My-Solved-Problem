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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        int level = 0;

        while (queue.size() > 0) {
            int size = queue.size();

            List<Integer> currLevel = new ArrayList<>();

            while (size-->0) {
                TreeNode rNode = queue.remove();

                currLevel.add(rNode.val);

                if (rNode.left != null) {
                    queue.add(rNode.left);
                }
                if (rNode.right != null) {
                    queue.add(rNode.right);
                }
            }

            if (level % 2 != 0) {
                Collections.reverse(currLevel);
            }

            level++;

            result.add(currLevel);
        }

        return result;
    }
}