import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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
    //完全看代码随想录，这道题的思路不容易
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if(backT(root) == 0){//0说明root没有覆盖
            res++;
        }
        return res;
    }

    private int backT(TreeNode root){
        //空节点，这里有覆盖
        if(root == null) return 2;

        int left = backT(root.left);
        int right = backT(root.right);

        //情况1，左右节点都有覆盖
        if(left==2 && right==2) return 0;

        //情况2，有个子节点没有覆盖
        if(left==0 || right==0){
            res++;
            return 1;
        }

        //情况3，有子节点有camera
        if(left==1 || right==1){
            return 2;
        }

        // 以上代码我没有使用else，主要是为了把各个分支条件展现出来，这样代码有助于读者理解
        // 这个 return -1 逻辑不会走到这里。
        return -1;


    }
}
// @lc code=end

