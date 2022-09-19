/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        //运气很好,一次通过.
        if(root == null) return true;

        int diff = Math.abs(getDepth(root.left)-getDepth(root.right));
        //这一步比较关键
        //判断的标准是,左右子树深度差值小于2,并且都为平衡二叉树,才能return true;
        if(diff < 2 && isBalanced(root.left) && isBalanced(root.right)) return true;
        else return false;
    }

    public int getDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getDepth(root.right), getDepth(root.left));
    }
}
// @lc code=end

