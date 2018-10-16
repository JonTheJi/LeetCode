/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            result.add(root.val);
            root = root.right;
        }

        return result;
    }
}
