/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            List<Node> currLevel = new ArrayList<>();

            while (size-->0) {
                Node rNode = queue.remove();
                
                currLevel.add(rNode);

                if (rNode.left != null) {
                    queue.add(rNode.left);
                }
                if (rNode.right != null) {
                    queue.add(rNode.right);
                }
            }
            rearrangeNodes(currLevel);
        }

        return root;
    }
    private void rearrangeNodes(List<Node> list) {
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next = list.get(i+1);
        }
    }
}