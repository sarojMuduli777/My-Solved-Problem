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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            while (size-->0) {
                TreeNode removeNode = queue.remove();

                currLevel.add(removeNode.val);

                if (removeNode.left != null) {
                    queue.add(removeNode.left);
                }
                if (removeNode.right != null) {
                    queue.add(removeNode.right);
                }
            }
            result.add(currLevel);
        }

        reverse(result);
        return result;
    }
    private void reverse(List<List<Integer>> temp) {
        int left = 0, right = temp.size()-1;

        while (left < right) {
            List<Integer> tmp = temp.get(left);
            temp.set(left, temp.get(right));
            temp.set(right, tmp);
            left++;
            right--;
        }        
    }
}