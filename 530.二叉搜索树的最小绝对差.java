import javax.sound.midi.Track;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    int minNum = Integer.MAX_VALUE;
    TreeNode pre = null;
    int res = 1000000;
    public int getMinimumDifference(TreeNode root) {

        if(root == null) return 0;
        dfs(root);
        return res;

    }
    //这个代码运行只能通过50%的测试case；
    // public int dfs(TreeNode root){
    //     if(root == null) return 999;
    //     if(root.left == null && root.right == null) return root.val;
    //     if(root.left == null && root.right != null) return Math.min(root.right.val - root.val, dfs(root.right));
    //     if(root.left != null && root.right == null) return Math.min(root.val - root.left.val, dfs(root.left));

    //     if(root.left != null && root.right != null){
    //         int minL = dfs(root.left);
    //         int minR = dfs(root.right);
    //         int leftAndR = root.val - root.left.val;
    //         int rightAndR = root.right.val - root.val;
    //         int res1 = Math.min(minL, minR);
    //         int res2 = Math.min(leftAndR, rightAndR);
    //         return(Math.min(res1, res2));
    //     }
    //     return 0;
        
    // }

    public void dfs(TreeNode root){
        if(root ==  null) return;
        //BST 采用前序遍历，则形成一个递增序列。每次计算差值，并且记录最小值即可。
        //需要使用一个全局变量，记录上一个遍历的点位。以便下一次进行计算；
        dfs(root.left);
        if(pre != null){
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
// @lc code=end

