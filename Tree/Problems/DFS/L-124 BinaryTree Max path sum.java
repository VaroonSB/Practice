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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = sum(node.left);
        int right = sum(node.right);

        left = Math.max(0, left);
        right = Math.max(0, right);

        int nodeSum = left + right + node.val;
        maxSum = Math.max(maxSum, nodeSum);

        return Math.max(left, right) + node.val;
    }
}