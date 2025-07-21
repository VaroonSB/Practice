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
    int result;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return result;

    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        k--;
        if (k == 0) {
            result = node.val;
            return;
        }

        inorder(node.right);
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
    PriorityQueue<Integer> minHeap;
    public int kthSmallest(TreeNode root, int k) {
        minHeap = new PriorityQueue<>();

        inorder(root);

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = minHeap.poll();
        }

        return result;
    }

    void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        minHeap.offer(node.val);

        inorder(node.right);
    }
}