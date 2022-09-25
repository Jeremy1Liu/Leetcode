import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    //我完全沿用中序和后序来构造的方法，可以实现前序中序的构造。
    //核心就是切割法。
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int[] preO;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length < 1) return null;
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }

        preO = preorder;
        TreeNode root = BuildTree(0, preorder.length-1, 0, inorder.length-1);
        return root;

    }
    public TreeNode BuildTree(int pl, int pr, int il, int ir){
        if(pl>pr || il>ir) return null;
        int rootVal = preO[pl];
        int rootIndex = inOrderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = BuildTree(pl+1, pl+rootIndex-il, il, rootIndex-1);
        root.right= BuildTree(pl+rootIndex-il+1,pr, rootIndex+1, ir);

        return root;
    }
}
// @lc code=end

