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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }

        return;
        // solution(root);
    }

    TreeNode solution(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            TreeNode rightMostInLeft = findRightMostRight(node.left);
            rightMostInLeft.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return solution(node.right);
    }

    TreeNode findRightMostRight(TreeNode node) {
        if (node.right == null) {
            return node;
        }

        return findRightMostRight(node.right);
    }
}