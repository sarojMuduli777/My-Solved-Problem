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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        // if root is null return an empty list.
        if (root == null) {
            return result;
        }

        // Create a queue first.
        Queue<TreeNode> queue  = new ArrayDeque<>();

        // Add root as a first element.
        queue.add(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE; // Create a max variable.
            int size = queue.size();

            while (size-->0) {
                TreeNode rNode = queue.remove();

                // Compare wiht max and store that in max variable.
                max = Math.max(rNode.val, max);

                // Add my left child.
                if (rNode.left != null) {
                    queue.add(rNode.left);
                }

                // Add my rihgt child.
                if (rNode.right != null) {
                    queue.add(rNode.right);
                }
            }
            // Add current level's max in resutl.
            result.add(max);
        }

        return result;
    }
}