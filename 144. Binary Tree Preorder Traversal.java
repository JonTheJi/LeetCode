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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                result.add(root.val);
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }

        return result;
    }
}
