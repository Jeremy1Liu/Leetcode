import java.util.HashMap;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    //看的题解高赞答案；
    //使用分割法，利用后序的最后一个值，到中序找到位置，完成分割；
    //后序后值为root的val, root的left，则构造一个树，用同样的方法。但要考虑输入的值的格式
    //中序的分割的前一半，为root的left，后一半为root的right；
    //利用中序left部分的长度，在后序找到left的部分，和right的部分。
    //值得多思考一下这道题。
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length-1, 0, post.length-1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe){
        if(ie < is || pe < ps) return null;

        int rootVal = post[pe];
        int rootIndex = inOrderMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);

        node.left = buildTree(is, rootIndex-1, ps, ps+rootIndex-is-1);
        node.right= buildTree(rootIndex+1, ie, ps+rootIndex-is, pe-1);

        return node;
    }
}
// @lc code=end

