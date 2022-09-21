/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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
 */
class Solution {
    //需要新建一个函数，输入nums, le,ri,能不断递归生成Tree
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return BuildTree(nums, 0, nums.length-1);
    }
    public TreeNode BuildTree(int[] nums, int le, int ri){
        if(le>ri) return null;

        //找到最大值和最大值的index，利用此，构造Tree
        int maxnum=0, maxindex=le;
        for(int i=le; i<=ri; i++){
            if(nums[i] > maxnum){
                maxnum = nums[i];
                maxindex = i;
            }
        }

        TreeNode root = new TreeNode(maxnum);
        root.left = BuildTree(nums, le, maxindex-1);
        root.right= BuildTree(nums, maxindex+1, ri);

        return root;
    }
}
// @lc code=end

