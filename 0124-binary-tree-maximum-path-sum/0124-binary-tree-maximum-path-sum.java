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
        int sum = 0;
        int maxPathSum = 0;

        Pair(int sum, int maxPathSum) {
            this.sum = sum;
            this.maxPathSum = maxPathSum;
        }
    }

    public int maxPathSum(TreeNode root) {
        // Return resultant maximum paht sum.
        return findMaxPathSum(root).maxPathSum;
    }

    // Helper method for finding the best path sum.
    private Pair findMaxPathSum(TreeNode root) {
        // Base case.
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE);
        }
        // ** Note Integer.MIN_VALUE because for this testcase. [-3] 
        
        // Recursively call from left and right and collect all necessary data from left child and right child.
        Pair leftPair = findMaxPathSum(root.left);
        Pair rightPair = findMaxPathSum(root.right);

        // If path sum from left child is not add any value for me then add 0 if it add any value to me then add that value. Same as for right child.
        int bestPathSumFromLeft = Math.max(leftPair.sum, 0);
        int bestPathSumFromRight = Math.max(rightPair.sum, 0);

        // Calculate the current path sum add best paht sum my left and best path sum form right and add me.
        int currPathSum = bestPathSumFromLeft + bestPathSumFromRight + root.val;

        // for overall path sum add maxium of my current path sum and leftPair maximum path sum and rihgt pair maximum paht sum.
        int orverAllPathSum = Math.max(currPathSum, Math.max(leftPair.maxPathSum, rightPair.maxPathSum));

        // Return a new pair as maximum of best path sum form left + me and best Path sum form right and me and overall maximum path sum till now.
        return new Pair(Math.max(bestPathSumFromLeft + root.val , bestPathSumFromRight +    root.val), orverAllPathSum);
    }
}