import java.util.ArrayList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traverse(root, 0, res);
        return res;

    }

    public void traverse(TreeNode root, int depth, List<List<Integer>> res) {
        if(root == null) return;
        if(depth >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        if(depth %2 ==0){
            res.get(depth).add(root.val);
        }
        else{
            //注意List的add使用方式
            res.get(depth).add(0,root.val);
        }
        traverse(root.left, depth+1, res);
        traverse(root.right, depth+1, res);
    }
    
}
// @lc code=end

