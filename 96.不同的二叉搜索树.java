/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        //看到代码随想录，这道题递推公式比较难；
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<n+1; i++){
            for(int j=0; j<=i-1; j++){
                //假设以1为根，则左子树0个元素，右子树i-1-0个元素，能组成组合为dp[0]*dp[i-1];
                //假设以j+1为根，则左子树j个元素，右子树i-1-j个元素。因为根占据一个元素；
                //则dp[i] 以j+1为根， = dp[j] * dp[i-1-j];
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];

    }
}
// @lc code=end

