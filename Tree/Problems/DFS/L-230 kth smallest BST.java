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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return solution(root, k).val;
    }

    TreeNode solution(TreeNode node, int k) {
        if (node == null) {
            return null;
        }

        TreeNode left = solution(node.left, k);

        count++;

        if (count == k) {
            return node;
        }

        if (left != null) {
            return left;
        }

        return solution(node.right, k);
    }
}