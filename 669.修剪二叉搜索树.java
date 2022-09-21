/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;

        //下行，相当于完全放弃右边的节点，左边的节点修建之后返回；
        //如果左边为空，则相当于返回了null。实际上隐含的是，也放弃了root节点。
        if(root.val > high) return trimBST(root.left, low, high);

        //相当于完全放弃左边的节点，右边修建之后，返回；
        else if(root.val < low) return trimBST(root.right, low, high);

        //如下情况，说明root在low和high中间，root可以保留；但左右需要剪枝；
        else{
            root.right = trimBST(root.right, low, high);
            root.left = trimBST(root.left, low, high);
        }
        return root;

    }
}
// @lc code=end

