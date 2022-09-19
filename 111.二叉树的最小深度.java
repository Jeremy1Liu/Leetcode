/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        // if(root != null && root.right == null && root.left == null) return 1;
        // else if(root != null && root.right == null && root.left != null) return 1+minDepth(root.left);
        // else if(root != null && root.right != null && root.left == null) return 1+minDepth(root.right);
        // else if(root == null) return 0;

        if(root != null){
            //当一侧为空,则最小深度为另一侧的深度
            if(root.right == null && root.left != null) return 1+minDepth(root.left);
            else if(root.right != null && root.left == null) return 1+minDepth(root.right);
            //当左右节点都为空,则找到了叶节点,返回1;
            else if(root.right == null && root.left == null) return 1;
        }
        else if(root==null) return 0;

        //当左右节点都不为空,则对比左右子树的深度,找出最小的.
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));

    }
}
// @lc code=end

