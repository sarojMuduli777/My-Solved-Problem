/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // Check root.val is equal to our any value.
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // Find on left.
        TreeNode findInLeft = lowestCommonAncestor(root.left, p, q);
        // Find on Right.
        TreeNode findInRight = lowestCommonAncestor(root.right, p, q);

        // If this is the point where two element are devides like one is in left
        // and another in right. So directly return it.
        if (findInLeft != null && findInRight != null) {
            return root;
        }

        // Return the not null value.
        if (findInLeft != null) {
            return findInLeft;
        } else if (findInRight != null) {
            return findInRight;
        } else {
            return null;
        }
    }
}