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
    public int findBottomLeftValue(TreeNode root) {
        // if root is null return directly -1.
        if (root == null) {
            return -1;
        }

        // Create a resultant variable initially root's value.
        int lastRowValue = root.val;

        // Create a queue.
        Queue<TreeNode> queue = new ArrayDeque<>();

        // Add root as first element.
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = true; // Flag for getting frst element in each level.
            
            while (size-->0) {
                if (flag) {
                    // if flag is true then store it.
                    lastRowValue = queue.peek().val;
                    flag = false; // Make flag false.
                }

                // pop the current node.
                TreeNode rNode = queue.remove();                

                // Add current node's left child if exist.
                if (rNode.left != null) {
                    queue.add(rNode.left);
                } 
                // Add current node's right if exist.
                if (rNode.right != null) {
                    queue.add(rNode.right);
                }                
            }
        }

        return lastRowValue;
    }
}