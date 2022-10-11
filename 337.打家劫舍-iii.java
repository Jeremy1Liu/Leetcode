/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
import java.util.HashMap;
import java.util.Map;

class Solution {
    

    public int rob(TreeNode root) {
        //方法1：直接递归；
        // if(root == null) return 0;
        // //本题一定采用后序遍历，因为使用递归函数的返回值来做下一步计算；
        // //单纯递归的时间复杂度是n平方；提交会超时；
        // int money = root.val;
        // if(root.left != null){ //需要加这个判定条件，否则invalid index;
        //     money += rob(root.left.left) + rob(root.left.right);
        // }
        // if(root.right != null){ //需要加这个判定条件，否则invalid index;
        //     money += rob(root.right.left) + rob(root.right.right);
        // }
        // return Math.max(money, rob(root.left)+rob(root.right));

        //方法2：使用Map来记录每个节点的最大结果值，避免重复计算，时间复杂度为n；
        // Map<TreeNode, Integer> memo = new HashMap<>();
        // return robAction(root, memo);

        //方法3：用两个数组来存储是否包含这个点;
        //res[0] 存储不包含这个root的最大值；
        //res[1] 存储包含这个root.val的最大值；
        //结果就是这两个中的较大者；
        int[] res = robAction2(root);
        return Math.max(res[0], res[1]);
    }

    //
    public int robAction(TreeNode root, Map <TreeNode, Integer> memo){
        if(root == null) return 0;
        //这里尝试调用Map
        if(memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if(root.left != null) money += robAction(root.left.left, memo) + robAction(root.left.right, memo);
        if(root.right!= null) money += robAction(root.right.left,memo) + robAction(root.right.right,memo);
        int res = Math.max(money, robAction(root.left, memo) + robAction(root.right, memo));
        memo.put(root, res);
        
        return res;
    }

    //
    public int[] robAction2(TreeNode root) {
        int res[] = new int[2];
        if(root == null) return res;

        //使用返回的结果数组避免重复递归，直接调用两个子节点的结果数组；
        int[] left = robAction2(root.left);
        int[] right = robAction2(root.right);

        //这个res[0]是不包含root。val, 但是调用两个子节点的最大结果；
        //root的两个子节点的最大值，要对比res的两个值才可以；
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //res[1]是包括root.val, 同时加上不包括两个子节点的最大值；
        res[1] = root.val + left[0] + right[0];

        return res;

    }
}
// @lc code=end

