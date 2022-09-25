/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root; // 第一种情况，root为空；
        if(root.val == key){
            //第二种情况，删除节点左右子树为空
            if(root.left == null && root.right == null){
                root = null;
            }
            //第三种情况，节点左树为空
            else if(root.right !=null && root.left == null){
                root = root.right;
            }
            //第四种情况，节点右树为空
            else if(root.left != null && root.right == null){
                root = root.left;
            }
            //第五种情况，左右节点都不为空
            else{
                TreeNode cur = root.right;
                while(cur.left != null) cur = cur.left;

                //把要删除节点的左子树，接到右子树最左节点上（大于root的最小节点）
                cur.left = root.left;
                root = root.right;

            }
        }
        //root在上面程序有改变，所以下面这里只能用else if,
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        return root;


    }
}
// @lc code=end

