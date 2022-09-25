/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //这个不好理解。看了网上的代码照着写的

        if(root == p || root == q || root == null) return root;

        TreeNode lr = lowestCommonAncestor(root.left, p, q);
        TreeNode rr = lowestCommonAncestor(root.right, p, q);

        // if(lr == null || rr != null) return rr;
        // else if(lr != null || rr == null) return lr;
        //左子树，右子树，皆非空，以为能找到LCA，则汇合点为此时的root；
        if(lr != null && rr != null) return root;
        if(lr == null) return rr;

        return lr;


    }
}
// @lc code=end

