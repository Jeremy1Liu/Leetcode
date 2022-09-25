import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //此题为插入BST，并不要求平衡，所以不难；
        if(root == null) return new TreeNode(val);

        //这一步关键，用root的左右指针，接住返回回来的树。
        //到达树的叶子节点，也就是null的时候，新建了TreeNode的节点。
        //然后按照出栈的顺序，依次接入root的子节点。
        //最后返回接上了新节点的root；
        if(root.val < val) root.right = insertIntoBST(root.right, val);
        else if(root.val > val) root.left = insertIntoBST(root.left, val);

        return root;

    }
}
// @lc code=end

