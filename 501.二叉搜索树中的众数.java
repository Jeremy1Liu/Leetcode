import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    int count;
    int maxCount;
    TreeNode pre = null;
    List<Integer> res2 = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        res2.clear();
        
        if(root == null) return new int[0];
        dfs(root);
        int[] res = new int[res2.size()];
        for(int i=0; i<res2.size(); i++){
            res[i] = res2.get(i);
        }

        return res;

    }
    public void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);

        //采用中序遍历，此处进行中间节点的操作
        //计数
        if(pre == null || root.val != pre.val) count=1;
        else{
            count++;
        }
        //更新结果以及maxCount
        if(count > maxCount){
            res2.clear();
            res2.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            res2.add(root.val);
        }
        
        pre = root;

        dfs(root.right);
    }
}
// @lc code=end

