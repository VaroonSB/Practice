/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public List<String> serialize(TreeNode root) {
        List<String> strings = new ArrayList<>();
        serialize(root, strings);
        return strings;
    }

    void serialize(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("null");
            return;
        }

        list.add(String.valueOf(node.val));

        serialize(node.left, list);
        serialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(List<String> strings) {
        Collections.reverse(strings);
        TreeNode root = deserializeHelper(strings);
        return root;
    }

    TreeNode deserializeHelper(List<String> list) {
        String val = list.remove(list.size() - 1);

        if (val.charAt(0) == 'n') {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));