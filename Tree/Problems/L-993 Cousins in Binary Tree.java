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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return level(root, xx, 0) == level(root, yy, 0) && !isSibling(root, xx, yy);
    }

    static TreeNode findNode(TreeNode node, int x) {
        if (node == null) {
            return null;
        }

        if (node.val == x) {
            return node;
        }

        TreeNode left = findNode(node.left, x);
        if (left != null) {
            return left;
        }
        return findNode(node.right, x);
    }

    boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return (node.left == x && node.right == y) || (node.right == x && node.left == y) || isSibling(node.left, x, y) || isSibling(node.right, x, y);
    }

    int level(TreeNode node, TreeNode x, int l) {
        if (node == null) {
            return 0;
        }

        if (node == x) {
            return l;
        }

        int lev = level(node.left, x, l + 1);
        if (lev != 0) {
            return lev;
        }
        return level(node.right, x, l + 1);
    }
}