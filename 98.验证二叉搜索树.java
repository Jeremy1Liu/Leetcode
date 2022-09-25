/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.right != null && root.left != null){
            return (root.left.val < root.val && root.val < root.right.val
            && isValidBST(root.left) && isValidBST(root.right));
            
        }
        if(root.right == null && root.left != null){
            return (root.left.val < root.val 
            && isValidBST(root.left) && isValidBST(root.right));

        }
        if(root.right != null && root.left == null){
            return (root.val < root.right.val
            && isValidBST(root.left) && isValidBST(root.right));

        }
        return false;

    }
}
// @lc code=end

