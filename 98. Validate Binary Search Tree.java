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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || stack.size() != 0) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == null) {
                pre = root;
            } else {
                if (pre.val >= root.val) {
                    return false;
                }
                pre = root; // remember to update pre 
            }
            root = root.right;
        }
        return true;
    }
}
