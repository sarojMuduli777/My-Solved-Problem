import java.util.*;

public class findPathRootToNode {
    // Path to store the nodes along the way
    ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        findPathRootToNode obj = new findPathRootToNode();
        TreeNode root = obj.constructTree();
        
        if (obj._findPathRootToNode(root, 7)) {
            Collections.reverse(obj.path); // Reverse the path for correct order from root to target
            System.out.println(obj.path);
        } else {
            System.out.println("Path not found");
        }
    }

    // Method to find the path from root to a given node
    boolean _findPathRootToNode(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        // Check if current node is the target node
        if (root.val == target) {
            path.add(root.val);
            return true;
        }
        // Recursively check in the left and right subtrees
        if (_findPathRootToNode(root.left, target) || _findPathRootToNode(root.right, target)) {
            path.add(root.val); // Add current node to path if target is found in subtree
            return true;
        }
        return false;
    }

    // Method to construct the tree
    TreeNode constructTree() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Node value: ");
        int val = sc.nextInt();
        if (val == -1) {
            return null; // Return null for sentinel value -1
        }
        TreeNode root = new TreeNode(val);
        System.out.print(" Enter Left child of " + val + ": ");
        root.left = constructTree();
        System.out.print(" Enter Right child of " + val + ": ");
        root.right = constructTree();
        
        return root;
    }
}

// Class to define a tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
