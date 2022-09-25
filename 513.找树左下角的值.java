import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

import com.sun.source.tree.Tree;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    public int findBottomLeftValue(TreeNode root) {
        //List<List<Integer>> res = new ArrayList<>();
        int resInt=0;
        
        Queue<TreeNode> que = new LinkedList<>();
        if(root!=null) que.offer(root);

        //层序遍历需要2层循环。一层控制queue非空，则遍历所有节点 
        //二层控制单层，每层达到长度，则自动进入下一层。
        while(!que.isEmpty()){
            //List<Integer> itemList = new ArrayList<>();
            int len = que.size();

            for(int i=0; i<len; i++){
                TreeNode temp = que.peek();
                //这是到了最后一层，最左节点的标记
                if(i==0) resInt = temp.val;

                que.poll();
                //itemList.add(temp.val);

                //添加节点有前提，需要非空
                if(temp.left!=null) que.add(temp.left);
                if(temp.right!=null) que.add(temp.right);
                
                
            }
            //res.add(itemList);
            
        }
        return resInt;

    }
}
// @lc code=end

