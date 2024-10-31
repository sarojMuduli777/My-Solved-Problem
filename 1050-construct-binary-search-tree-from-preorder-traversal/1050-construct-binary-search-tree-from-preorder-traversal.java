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
    // Global pointer for tracing the index.
    private int idx;

    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        // Call helper method.
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(int[] preorder, int min, int max) {
        // Bast case.
        if (idx == preorder.length || preorder[idx] <= min || preorder[idx] >= max) {
            return null;
        }       

        // Creater a new node.
        TreeNode root = new TreeNode(preorder[idx]);
        idx++; // Go to next index.

        // Make my left subtree.
        root.left = constructBST(preorder, min, root.val);
        // Make my right subtree.
        root.right = constructBST(preorder, root.val, max);

        // return me.
        return root;
    }
}