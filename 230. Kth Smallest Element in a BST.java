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
    public int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new ArrayDeque<>();
        int result = 0;
        int count = 0;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (k == count) {
                result = root.val;
                break;
            }
            root = root.right;
        }

        return result;
    }
}
