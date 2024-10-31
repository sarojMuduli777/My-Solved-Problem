/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {        
        StringBuilder sb = new StringBuilder();
        // Encode the string.
        encode(root, sb);

        return sb.toString();
    }
    // Encode hlper function.
    private void encode(TreeNode root, StringBuilder sb) {
        // Very simple perorder traversal create the string.
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");

        encode(root.left, sb);
        encode(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // Split the given string data ",".
        String[] arr = data.split(","); 

        // Decoe the split array.
        return decode(arr);
    }

    // Global Index for the split arry.
    int idx = 0; 

    private TreeNode decode(String[] arr) {  
        String data = arr[idx];      
        idx++;  // Get the data before increment.

        // Base case to avoid index out of bound.
        if (idx == arr.length) {
            return null;
        }

        // If null directly return null.
        if (data.equals("null")) {
            return null;
        }

        // Convert the string value into integer value.
        int value = Integer.parseInt(data);
        // Create a Tree node using that value.
        TreeNode root = new TreeNode(value);

        // Call my left child and right child.
        root.left = decode(arr);
        root.right = decode(arr);

        // At the end return me.
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));