/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        //di[i] 为正整数i拆分后的结果的最大乘积
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3; i<n+1; i++){
            //这里的j其实最大值是i-j，再大只是前一半的重复而已；
            for(int j=1; j<= i-j; j++){
                //注意这里要做两重比较
                //一重是对当前j的最大值，即内层max
                //二重是对当前i的所有j的求出dp[i]最大值,即结果的dp[i];
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }

        return dp[n];
    }
}
// @lc code=end

