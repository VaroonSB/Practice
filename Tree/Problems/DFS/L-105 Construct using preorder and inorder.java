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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solution(preorder, inorder);
    }

    TreeNode solution(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int inorderRootIndex = findRootIndex(inorder, preorder[0]);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, inorderRootIndex+1), Arrays.copyOfRange(inorder, 0, inorderRootIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, inorderRootIndex+1, preorder.length), Arrays.copyOfRange(inorder, inorderRootIndex+1, inorder.length));

        return root;
    }

    int findRootIndex(int[] inorder, int root) {
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
            }
        }
        return index;
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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length - 1, map);
    }

    TreeNode helper(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right) {
            return null;
        }

        int current = preorder[index];
        index++;

        TreeNode node = new TreeNode(current);

        if (left == right) {
            return node;
        }

        int inorderIndex = map.get(current);

        node.left = helper(preorder, inorder, left, inorderIndex - 1, map);
        node.right = helper(preorder, inorder, inorderIndex + 1, right, map);

        return node;
    }
}