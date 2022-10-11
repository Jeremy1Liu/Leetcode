import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
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
    int ans = -1;
    int rootVal;

    public int findSecondMinimumValue(TreeNode root) {
        rootVal = root.val;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        //如果ans已经记录，且root.val大于ans,则无需进行下一步，进行记录，直接返回即可
        //如果root.val小于ans，而且比rootVal大时，会进入最后一个if，进行记录。
        if(ans != -1 && root.val >= ans){
            return;
        }
        //当出现一个比rootVal大的值时，即记录之；
        //这里的隐含条件是，root.val<ans，说明找到了更小的root.val，
        //因此一定要记录
        else if(root.val > rootVal){
            ans = root.val;
        }
        dfs(root.left);
        dfs(root.right);
    }
    
}
// @lc code=end

