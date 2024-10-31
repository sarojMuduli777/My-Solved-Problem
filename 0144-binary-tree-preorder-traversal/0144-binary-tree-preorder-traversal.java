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
        int visited;

        Pair(TreeNode node, int visited) {
            this.node = node;
            this.visited = visited;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        // if root is null return an empty list.
        if (root == null) {
            return preorder;
        }

        // Our own stack of Pair type.
        Stack<Pair> stack = new Stack<>();

        // Add root first.
        stack.push(new Pair(root, 1));

        // Run until stack is not empty.
        while (!stack.isEmpty()) {
            // Get peek node first.
            Pair top = stack.peek();

            // If peek node is visited once.
            if (top.visited == 1) {
                // Visited count++.
                top.visited += 1;

                // add me.
                preorder.add(top.node.val);

                // Call my left child if exist.
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            } else if (top.visited == 2) { // if second time.
                top.visited += 1;            
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
            } else {
                // if Third time then pop out me.
                stack.pop();
            }
        }

        return preorder;
    }
}