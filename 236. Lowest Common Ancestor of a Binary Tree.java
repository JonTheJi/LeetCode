/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// how to know if this is the LCA ? -> left and right siblings contain p,
// Since we knew that the answer exists -> traverse the tree using DFS-postOrder -> we will have an answer
// the pre condition -> root != null return null otherwise
// post order condition -> if we find p or q -> return them
// if left or right has p || q -> return root -> our answer
// once we found the answer || the answer was returned already -> once left/ right
// that are not null return it.
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            TreeNode left = helper(root.left, p, q);
            TreeNode right = helper(root.right, p, q);
            if (root == p || root == q) {
                return root;
            }
            if (left != null && right != null) {
                return root;
            } else if (right != null) {
                return right;
            } else {
                return left;  // null if right and left both are null
            }
        }
        return null;
    }
}
