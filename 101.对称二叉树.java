import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode leftR, TreeNode rightR){
        //需要这样的end条件，并且避免出现空树的对比，因此把空树放在前面判定。
        if(leftR == null || rightR == null) {
            if(leftR == null && rightR == null){
                return true;
            }
            else return false;
        }

        //判定成功条件，左右的值相等，R的右子树等于L的左子树；R的左子树等于L的右子树。
        else if(leftR.val == rightR.val 
                && check(leftR.right, rightR.left)
                && check(rightR.right, leftR.left)) {
                    return true;
                }

        return false;

    }
}
// @lc code=end

