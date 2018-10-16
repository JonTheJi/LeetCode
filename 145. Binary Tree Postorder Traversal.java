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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || stack.size() != 0) {
            while (root != null) {
                result.addFirst(root.val);
                stack.addFirst(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }

        return result;
    }
}
