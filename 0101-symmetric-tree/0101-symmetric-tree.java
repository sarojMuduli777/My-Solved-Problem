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
    public boolean isSymmetric(TreeNode root) {
        // root is null return null (base case).
        if (root == null) {
            return true;
        }
        // Call helper function for further check.
        return _isSymmetric(root.left, root.right);
    }
    private boolean _isSymmetric(TreeNode left, TreeNode right) {
        // If both are null return true.
        if (left == null && right == null) {
            return true;
        }
        
        // If one of them is null then return false.
        if (left == null || right == null) {
            return false;
        }

        // Both's values are not equal return false.
        if (left.val != right.val) {
            return false;
        } 

        // Call for left and rihgt.
        boolean isLeft = _isSymmetric(left.left, right.right);
        boolean isRight = _isSymmetric(left.right, right.left);

        // If both are true then true otherwise return false.
        return isLeft && isRight;
    }
}