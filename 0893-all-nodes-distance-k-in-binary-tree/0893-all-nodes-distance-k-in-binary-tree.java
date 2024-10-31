/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Map <Chidl, Parent>
        Map<TreeNode, TreeNode> parent = new HashMap<>();        
        findParentOfAllNodes(root, parent); // Heper function for build the map.

        // restrictions for visited nodes.
        Set<TreeNode> visited = new HashSet<>();
        // Queue for the current Level.
        Queue<TreeNode> queue = new ArrayDeque<>();

        // Add root as first node alos marked as visited.
        queue.add(target);
        visited.add(target);

        // Simple BFS template.
        while (!queue.isEmpty()) {
            // If K == 0 i.e we found our target level then break.
            if (k == 0) {   
                break;
            }
         
            int size = queue.size();

            while (size-->0) {
                TreeNode rNode = queue.remove();

                // Add left child if not visited.
                if (rNode.left != null && !visited.contains(rNode.left)) {
                    queue.add(rNode.left);
                    visited.add(rNode.left);
                }

                // Add right chidl if not visited.
                if (rNode.right != null && !visited.contains(rNode.right)) {
                    queue.add(rNode.right);
                    visited.add(rNode.right);
                }

                // Add Parent of the current node if not visited.
                if (parent.get(rNode) != null && !visited.contains(parent.get(rNode))) {
                    queue.add(parent.get(rNode));
                    visited.add(parent.get(rNode));
                }
            }
            
            k--;    // Decrease the value of K.
        }

        // Convert the queue into Arraylist.
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove().val);
        }

        return result;
    }

    // Helper function for building the "Parent" Map.
    private void findParentOfAllNodes(TreeNode root, Map<TreeNode, TreeNode> parent) {
        // If root is null then return.
        if (root == null) {
            return;
        }

        //if i have a left child the add that child's parent as me.
        if (root.left != null) {
            parent.put(root.left, root);
        }

        //if i have a right child the add that child's parent as me.
        if (root.right != null) {
            parent.put(root.right, root);
        }

        // Recursively call left and then right.
        findParentOfAllNodes(root.left, parent);
        findParentOfAllNodes(root.right, parent);
    }
    
}