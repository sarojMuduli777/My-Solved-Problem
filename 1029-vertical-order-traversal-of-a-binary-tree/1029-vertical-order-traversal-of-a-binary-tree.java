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
    int maxLevel = 0;
    int minLevel = 0;
    private void verticalLevels(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        verticalLevels(root.left, level-1);
        verticalLevels(root.right, level+1);

        maxLevel = Math.max(maxLevel, level);
        minLevel = Math.min(minLevel, level);
    }
    class Pair implements Comparable<Pair> {
        TreeNode node;
        int vLevel;

        Pair(TreeNode node, int vLevel) {
            this.node = node;
            this.vLevel = vLevel;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.vLevel == o.vLevel) {
                return this.node.val - o.node.val;
            }

            return this.vLevel - o.vLevel;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        verticalLevels(root, 0);
        int  width = maxLevel - minLevel;
        int totalLevels = width+1;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < totalLevels; i++) {
            result.add(new ArrayList<>());
        }

        PriorityQueue<Pair> pPq = new PriorityQueue<>();

        pPq.add(new Pair(root, -minLevel));

        while (pPq.size() > 0) {
            int size = pPq.size();

            PriorityQueue<Pair> cPq = new PriorityQueue<>();
            while (size-->0) {
                Pair rNode = pPq.remove();
                result.get(rNode.vLevel).add(rNode.node.val);

                if (rNode.node.left != null) {
                    cPq.add(new Pair(rNode.node.left, rNode.vLevel-1));
                }
                if (rNode.node.right != null) {
                    cPq.add(new Pair(rNode.node.right, rNode.vLevel+1));
                }
            }            
            pPq = cPq;
        }

        return result;
    }
}