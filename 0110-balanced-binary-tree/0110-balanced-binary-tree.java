class Pair {
    boolean isBalanced = true;
    int height = 0;

    Pair() {} // Empth Constructor.

    Pair(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}
// TC : O(N) , SC : (H)

class Solution { 
    private Pair _isBalanced(TreeNode root) {
        if (root == null) {
            return new Pair();
        }

        Pair leftSubTree = _isBalanced(root.left);
        Pair rightSubTree = _isBalanced(root.right);

        int diff = Math.abs(leftSubTree.height - rightSubTree.height);

        if (diff > 1 || !leftSubTree.isBalanced || !rightSubTree.isBalanced) {
            return new Pair(false, Math.max(leftSubTree.height, rightSubTree.height) + 1);
        } else {
            return new Pair(true, Math.max(leftSubTree.height, rightSubTree.height) + 1);
        }
    }

    public boolean isBalanced(TreeNode root) {
        Pair result = _isBalanced(root);

        return result.isBalanced;
    }
}