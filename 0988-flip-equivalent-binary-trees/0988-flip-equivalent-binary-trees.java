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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // If both trees are empty then return true.
        if (root1 == null && root2 == null) {
            return true;
        }

        // if one of the tree node is null then return false.
        if (root1 == null || root2 == null) {
            return false;
        }

        // If both tree node's value is equal then go and check further if their 
        // are not equal then derectly return fasle.
        if (root1.val == root2.val) {
            // Now without flipping the tree lets call form left subtree and 
            // right subtree also.
            boolean withoutFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

            // if whithout flip it's false then we assume that both trees are 
            // fliped now.
            boolean withFlip = false;
            
            // Then call both the tree alternatively.
            if (withoutFlip == false) {
                withFlip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
            }

            // if any of then is true return true.
            return withoutFlip || withFlip;
        } else {
            // Otherwise return false.
            return false;
        }
    }
}