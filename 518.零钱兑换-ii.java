/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1; //这一步为什么要设定为1
        for(int i=0; i<coins.length; i++){
            //只有在j=coins[i]之后，coins[i]才发挥了作用，因此从这里开始；
            //每次都可以在之前的dp[j]的基础上加上dp[j-coins[i]];
            //dp[j-coins[i]]相当于不含coins[i]的原组合数量，加上coins[i]即成为新组合；
            
            for(int j = coins[i]; j<=amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];

    }
}
// @lc code=end

