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
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public void recoverTree(TreeNode root) {
        // Our own stack.
        Stack<Pair> stack = new Stack<>();

        // Let's find two problematic node.
        TreeNode a = null;
        TreeNode b = null;

        // Push root first.
        stack.push(new Pair(root, 1));

        // Two pointer for traversing the inorder of the tree.
        TreeNode prev = null;
        TreeNode curr = getNextInorder(stack);

        while (curr != null) {
            // If prev is not null and prev's val is gerate than curr val then
            // it is a problematic area.
            if (prev != null && prev.val > curr.val) {
                // if first problematic node is null then assign prev to it.
                if (a == null) {
                    a = prev;
                    b = curr;
                } else {
                    // if second then asign it to b.
                    b = curr;
                }
            }
            // move ahead.
            prev = curr;
            curr = getNextInorder(stack);
        }

        // Swap both values.
        int tVal = a.val;
        a.val = b.val;
        b.val = tVal;

        return;        
    }

    private TreeNode getNextInorder(Stack<Pair> stack) {
        while (!stack.isEmpty()) {
            Pair top = stack.peek();

            if (top.state == 1) {
                // Preorder.
                top.state++;
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                // Inorder.
                top.state++;
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
                return top.node;
            } else {
                // Postorder.
                stack.pop();
            }
        }

        return null;
    }
}