/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null) {
            return levelOrder;
        }
        
        Queue<Node> queue = new ArrayDeque<>();
        
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            while (size-->0) {
                Node rNode = queue.remove();
                currLevel.add(rNode.val);

                for (Node child : rNode.children) {
                    if (child != null) {
                        queue.add(child);
                    }
                }
            }
            levelOrder.add(currLevel);
        }

        return levelOrder;
    }
}