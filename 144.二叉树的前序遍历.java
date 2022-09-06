/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        //注释掉的部分是递归的方法；
        // List<Integer> res = new ArrayList<Integer>();
        // preOrder(root, res);
        // return res;

        //如下方法是迭代法
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        while(! stack1.isEmpty()){
            TreeNode node = stack1.pop();
            res.add(node.val);
            if(node.right != null) stack1.push(node.right);
            if(node.left != null) stack1.push(node.left);

        }
        return res;

    }

    // public void preOrder(TreeNode root, List<Integer> res){
    //     if(root == null) return;
    //     res.add(root.val);
    //     preOrder(root.left, res);
    //     preOrder(root.right, res);
    // }
}
// @lc code=end

