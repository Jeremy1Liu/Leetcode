import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null) return ans;
        dfs(root, targetSum);
        return ans;
        
    }
    public void dfs(TreeNode root, int target) {
        path.add(root.val);
        target -= root.val;
        
        if(root.left == null && root.right == null
            && target == 0) {
                ans.add(path);
                return;
        }
        if(root.left != null) dfs(root.left, target);
        if(root.right!= null) dfs(root.right, target);

        //这一步用到了回溯，目前还不懂。
        path.remove();
    }

}
// @lc code=end

