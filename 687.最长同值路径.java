/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    //完全看的网上的答案；不是很懂。
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int a = helper(root);
        return res;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        if(root.left != null && root.val == root.left.val){
            left++;
        }
        else left = 0;
        if(root.right != null && root.val == root.right.val){
            right++;
        }
        else right = 0;
        //当root作为根节点，最大路径为left+right;
        res = Math.max(res, left + right);
        //这个返回值，是返回左路径或者右路径中的较大值；
        return Math.max(left, right);
    }
}
// @lc code=end

