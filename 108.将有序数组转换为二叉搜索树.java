import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        TreeNode root = numToBST(nums, 0, len-1);
        return root;
    }
    public TreeNode numToBST(int[] nums, int l, int r){
        if(l > r) return null;
        
        int mid = l + (r-l)/2;
        TreeNode cur = new TreeNode(nums[mid]);
            
        cur.left = numToBST(nums, l, mid-1);
        cur.right = numToBST(nums, mid+1, r);
        return cur;
        
        
        
    }
}
// @lc code=end

