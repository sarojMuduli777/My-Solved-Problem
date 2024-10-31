class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = root.left != null ? minDepth(root.left) : Integer.MAX_VALUE;
        
        int rightDepth = root.right != null ? minDepth(root.right) : Integer.MAX_VALUE;

        int minDepth = Math.min(leftDepth, rightDepth) + 1;

        return minDepth;
    }
}