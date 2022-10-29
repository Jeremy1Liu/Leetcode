/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //完全看的代码随想录的内容
        //还不太理解这5个状态的运行逻辑。。。
        int len = prices.length;
        if(len == 0) return 0;
        //定义5种状态，0没有操作，1第一次买入，2第一次卖出，3第二次买入，4第二次卖出
        int[][] dp = new int[len][5];
        dp[0][1] = - prices[0]; //买入股票，所以手里现金为负；
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = - prices[0];

        for(int i=1; i < len; i++){
            dp[i][0] = dp[i-1][0];
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] -prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i][3] + prices[i]);
        }

        return dp[len-1][4];

    }
}
// @lc code=end

