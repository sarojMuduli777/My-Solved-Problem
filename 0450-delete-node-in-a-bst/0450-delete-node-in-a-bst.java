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
    public TreeNode deleteNode(TreeNode root, int key) {        
        if (root == null) {
            // if root is null return null.
            return null;
        } else if (root.val == key) { 
            // if root's val is equal to key's val then check these condition.
            if (root.left == null && root.right == null) {
                // If i am leaf node then return null.
                return null;
            } else if (root.left != null && root.right == null) {
                // if i am having only a left subtree then return that only.
                return root.left;
            } else if (root.left == null && root.right != null) {
                // if i am having only a right subtree then return that only.
                return root.right;
            } else {
                // If i am havng both left and right then follow these process.
                int minVal = getMinFormRightSubtree(root.right);
                // get minimum value from right subtree.
                root.val = minVal; // ovrerwrite root's value with min value.
                // delete the minmum node get we get from right subtree.
                root.right = deleteNode(root.right, minVal);
            }
        } else if (root.val > key) {
            // if root's val is greater then key then go left.
            root.left = deleteNode(root.left, key);
        } else {
            // if root's val is lessthan key then go right.
            root.right = deleteNode(root.right, key);
        }

        // Return root.
        return root;
    }
    private int getMinFormRightSubtree(TreeNode root) {
        // if i don't have any left child then return me as a minvlue.
        if (root.left == null) {
            return root.val;
        }
        // Recursively call for minimum value persent in left subtree.
        return getMinFormRightSubtree(root.left);
    }
}