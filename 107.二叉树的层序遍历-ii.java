import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //返回值是自底向上，从左到右的层序遍历
        //入栈需要是自上而下，从右到左的层序遍历；
        //在遍历完一层节点之后，将存储该层节点值的列表添加到结果列表的头部
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        //循环的控制条件是队列非空，
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = que.size();
            //针对队列中的每个节点，执行如下循环；
            //循环控制条件是队列的长度，size()
            for(int i=0; i<size; i++){
                //弹出一个节点，并保存。将value加入List, 并把非空的左右节点，加入队列
                TreeNode node = que.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if(left != null){
                    que.offer(left);
                }
                if(right != null){
                    que.offer(right);
                }
            }
            res.add(0,level);
        }

        return res;
    }
}
// @lc code=end

