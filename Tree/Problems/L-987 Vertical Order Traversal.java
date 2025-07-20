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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for BFS. Stores an object: {node, row, col}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{root.hashCode(), 0, 0});

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        nodeMap.put(root.hashCode(), root);

        while (!q.isEmpty()) {
            int[] removed = q.poll();

            TreeNode node = nodeMap.get(removed[0]);
            int row = removed[1];
            int col = removed[2];

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            map.get(col).get(row).add(node.val);

            if (node.left != null) {
                int leftHash = node.left.hashCode();
                nodeMap.put(leftHash, node.left);
                q.offer(new int[]{leftHash, row + 1, col - 1});
            }
            if (node.right != null) {
                int rightHash = node.right.hashCode();
                nodeMap.put(rightHash, node.right);
                q.offer(new int[]{rightHash, row + 1, col + 1});
            }
        }

        for (int col : map.keySet()) {
            List<Integer> colList = new ArrayList<>();
            for (int row : map.get(col).keySet()) {
                PriorityQueue<Integer> pq = map.get(col).get(row);
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}