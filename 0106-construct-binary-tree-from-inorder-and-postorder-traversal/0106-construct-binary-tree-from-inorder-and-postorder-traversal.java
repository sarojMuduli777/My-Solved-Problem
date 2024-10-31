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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructBinaryTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode constructBinaryTree(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei) {
        if (isi > iei || psi > pei) {
            return null;
        }

        // The last element in postorder is the root
        TreeNode root = new TreeNode(postorder[pei]);

        // Find the index of the root in inorder array
        int rootIndex = isi;
        int leftTreeSize = 0;

        while (rootIndex <= iei && inorder[rootIndex] != root.val) {
            rootIndex++;
            leftTreeSize++;
        }        

        // Recursively construct left and right subtrees
        root.left = constructBinaryTree(inorder, isi, rootIndex - 1, postorder, psi, psi + leftTreeSize - 1);
        
        root.right = constructBinaryTree(inorder, rootIndex + 1, iei, postorder, psi + leftTreeSize, pei - 1);

        return root;
    }
}