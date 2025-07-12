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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root == null) {
            return result;
        }
        q.offer(root);
        boolean flip = false;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (!flip) {
                    TreeNode current = q.pollFirst();
                    level.add(current.val);
                    // left and right
                    if (current.left != null) {
                        q.offerLast(current.left);
                    }
                    if (current.right != null) {
                        q.offerLast(current.right);
                    }
                } else {
                    TreeNode current = q.pollLast();
                    level.add(current.val);
                    // order flipped right and left, because next level is normal.
                    if (current.right != null) {
                        q.offerFirst(current.right);
                    }
                    if (current.left != null) {
                        q.offerFirst(current.left);
                    }
                }
            }
            flip = !flip;
            result.add(level);
        }
        return result;
    }
}