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

    class Pair {
        int diameter;
        int height;

        Pair() {
            diameter = 0;
            height = 0;
        }

        Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair result = _diameterOfBinaryTree(root);
        return result.diameter;
    }

    private Pair _diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return new Pair();
        }

        Pair diaOfLeftSubtree = _diameterOfBinaryTree(root.left);
        Pair diaOfRightSubtree = _diameterOfBinaryTree(root.right);

        int diaThroughRoot = diaOfLeftSubtree.height + diaOfRightSubtree.height;

        // My diameter.
        int myDiameter = Math.max(diaThroughRoot, Math.max(diaOfLeftSubtree.diameter, diaOfRightSubtree.diameter));
        
        int myHeight = Math.max(diaOfLeftSubtree.height, diaOfRightSubtree.height) + 1;

        return new Pair(myDiameter, myHeight);
    }
}