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
        TreeNode node;
        int idx;

        Pair(TreeNode node, int idx) {
            this.node= node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Pair> queue = new LinkedList<>();
        int maxWidth = 1;

        queue.addFirst(new Pair(root, 1));

        while (queue.size() > 0) {
            int size = queue.size();

            while (size-->0) {
                Pair rNode = queue.poll();
                
                if (rNode.node.left != null) {
                    queue.addLast(new Pair(rNode.node.left, 2*rNode.idx+1));
                }
                if (rNode.node.right != null) {
                    queue.addLast(new Pair(rNode.node.right, 2*rNode.idx+2));
                }
            }
            if (queue.isEmpty()) break;
            maxWidth = Math.max(maxWidth, (queue.getLast().idx - queue.getFirst().idx)+1);
        }

        return maxWidth;
    }
}