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
    // Global variable to store LCA.
    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = root; // Set lca equal to root.

        // Call helper method for finding potential lca.
        helper(root, p.val, q.val);

        return lca;
    }
    private void helper(TreeNode root, int val1, int val2) {
        // if root is null return directly.
        if (root == null) {
            return;
        }

        // if any given value is eqal to root's value then lca is root then retur
        if (root.val == val1 || root.val == val2) {
            lca = root;
            return;
        }

        // if above condition is not execute then i am a potentical lca.
        lca = root;
        
        // if both are less than me then call left.
        if (root.val > val1 && root.val > val2) {            
            helper(root.left, val1, val2);
        } else if (root.val < val1 && root.val < val2) {       
            // if both are greate than me then call right.     
            helper(root.right, val1, val2);
        } else {
            // if this node is the split node then return directly.      
            return;
        }
    }
}