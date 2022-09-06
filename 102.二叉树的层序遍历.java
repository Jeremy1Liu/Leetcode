/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        //对我来说的难点，1创建2阶数组；2控制每层的循环次数；
        checkFun02(root);
        return resList;
    }
    public void checkFun02(TreeNode node){
        if(node == null) return;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(node);

        while( !que.isEmpty()){
            List<Integer> itemList = new ArrayList<Integer>();
            int len = que.size();

            while(len > 0){
                TreeNode tempNode = que.poll();
                itemList.add(tempNode.val);

                if(tempNode.left != null) que.offer(tempNode.left);
                if(tempNode.right != null) que.offer(tempNode.right);
                len--;
            }
            resList.add(itemList);
        }
    }
}
// @lc code=end

