/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i=0; i<amount+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j < amount+1; j++){
                //这里需要额外增加一个判定，如果dp[j]是初始值，则跳过。
                //否则最后的结果会出错；会有很多max加到最后的数值；
                if(dp[j - coins[i]] == Integer.MAX_VALUE) continue;
                else dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        if(dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
// @lc code=end

