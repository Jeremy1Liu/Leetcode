/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一棵树的子树
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // //自己写的，通过了62/182测试，说明有问题。
        // if(root == null && subRoot == null) return true;
        // if(root == null || subRoot == null) return false;

        // if(root.val==subRoot.val){
        //     return isSubtree(root.left, subRoot.left)
        //     && isSubtree(root.right, subRoot.right) ;
            
        // }
        
        //     return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
        if(root == null) return false;
        return isSubT(root, subRoot) || isSubT(root.left, subRoot) || isSubT(root.right, subRoot);            
        
    }

    private boolean isSubT(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;

        if(root.val != subRoot.val) return false;
        return isSubT(root.left, subRoot.left) && isSubT(root.right, subRoot.right);
    }
}
// @lc code=end

