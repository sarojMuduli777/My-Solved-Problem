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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //Construct binary Tree function argument as preoder, starting index, 
        //end index, inorder , starting index, ending, index.

        return constructBinaryTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

    }
    private TreeNode constructBinaryTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {

        // Condition or boundaries of the array.
        if (psi > pei || isi > iei) {
            return null;
        }

        // Create the root node help of preorder array.
        TreeNode root = new TreeNode(preorder[psi]);

        // find the find the boundary of left subtree and right subtree.        
        int countElement = 0;   
        int itr = isi;

        while (inorder[itr] != preorder[psi]) {
            countElement++;
            itr++;
        }

        // Call recursively for my left subtree argument as preorder arry, 
        // starting index+1, starting index + element up that in inorder array, 
        // inorder array, starting index, starting index + iterator-1.

        root.left = constructBinaryTree(preorder, psi+1, psi + countElement, inorder, isi, itr-1);


        // Call recursively for my right subtree argument as preorder arry, 
        // starting index+countElement+1, ending index, inorder array,
        // iterator + 1 , ending index of inorder array.
        root.right = constructBinaryTree(preorder, psi+countElement+1, pei, inorder, itr+1, iei);

        return root;
    }
}