/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sumL=0, sumR=0, sumM=0;
        if(root.left != null && root.left.left == null && root.left.right == null) sumM = root.left.val;
        
        
        sumL += sumOfLeftLeaves(root.left);
        sumR = sumOfLeftLeaves(root.right);
        

        return sumL + sumR + sumM;

    }
}
// @lc code=end

