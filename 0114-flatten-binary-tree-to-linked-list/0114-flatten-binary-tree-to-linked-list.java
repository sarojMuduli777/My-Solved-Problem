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
    // TC : O(N^2) SC : O(H)
    public void flatten(TreeNode root) {
        // Base case.
        if (root == null) {
            return;
        }
        
        // First call left and then right.
        flatten(root.left);
        flatten(root.right);

        // Save the right subtree in a temporary variable.
        TreeNode temp = root.right;

        // Asign root's right to root's left tree.
        root.right = root.left;
        // Make root's left equal to null.
        root.left = null;
        TreeNode curr = root;
        
        // Traverse to the end of the tree.
        while (curr.right != null) {
            curr = curr.right;
        }
        
        // Now asign the right subtree to the end of the tree.
        curr.right = temp;
    }
}
