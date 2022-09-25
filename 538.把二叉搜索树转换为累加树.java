/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    //创建一个全局变量，存储上个位置的值，便于后面的累加；
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        reverseDfs(root);
        return root;
    }

    public void reverseDfs(TreeNode root){
        //递增是按照中序递归的反方向来的。最大的数，累加到最小的数
        //所以按照，右，中，左的顺序来DFS；
        //利用全局变量pre来传递数据，节点结构不变，只改变value；
        if(root == null) return;
        reverseDfs(root.right);
        //全局唯一改变的就是每次改变root.val
        root.val += pre;
        //pre的值更新很重要，全靠pre在递归循环中不断传递数据；
        pre = root.val;
        reverseDfs(root.left);

    }
}
// @lc code=end

