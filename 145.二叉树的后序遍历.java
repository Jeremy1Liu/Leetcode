/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {
        // List<Integer> res = new ArrayList<Integer>();
        // postOrder(root, res);
        // return res;

        //如下为迭代法
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        Stack<TreeNode> st = new Stack<>();
        

        st.push(root);
        while(!st.isEmpty()){
            
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.left != null) st.push(node.left);
            if(node.right != null) st.push(node.right);
        }
        return res;

    }

    // private void postOrder(TreeNode root, List<Integer> res){
    //     if(root == null) return;
        
    //     postOrder(root.left, res);
    //     postOrder(root.right, res);
    //     res.add(root.val);
    // }
}
// @lc code=end

