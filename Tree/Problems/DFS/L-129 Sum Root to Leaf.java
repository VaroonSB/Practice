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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    void helper(TreeNode node, int number) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            result += ((number * 10) + node.val);
            return;
        }

        helper(node.left, (number * 10) + node.val);
        helper(node.right, (number * 10) + node.val);
    }
}

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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = (sum * 10) + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return helper(node.left, sum) + helper(node.right, sum);
    }
}