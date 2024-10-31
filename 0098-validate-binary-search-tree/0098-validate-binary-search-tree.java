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
        // Call helper function root , minValue, maxValue as parameter.
        return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean _isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            // if root is null return true because empty tree is valid BST.
            return true;
        }

        // If my value is lessthan or equal to minValue or my value is greater 
        // than or equal to maxValue then derectly return false.
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        // Check for my left Subtree.
        boolean isLeftValid = _isValidBST(root.left, minValue, root.val);
        if (!isLeftValid) {
            // if it not valid then return false.
            return false;
        }

        // Check for my right subtree.
        boolean isRightValid = _isValidBST(root.right, root.val, maxValue);
        if (!isRightValid) {
            // If it not valid then return false.
            return false;
        }

        // if above condition are execut then it means my both subtree is valid.
        // then derectly return true.
        return true;
    }
}