/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] nums = new int [101];
        //这里看作往背包里放的物品
        for(int i=1; i<100; i++){
            nums[i] = i*i;
        }
        //创建背包
        int[] dp = new int [n+1];
        for(int i=0; i<n+1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        //求组合，非求排列，因此物品在外，背包容量在内；
        for(int i=1; i*i <= n; i++){
            //完全遍历背包容量j；
            for(int j=nums[i]; j<n+1; j++){
                //需要加判定条件，避免max带来的误差；
                if(dp[j-nums[i]] == Integer.MAX_VALUE) continue;
                else dp[j] = Math.min(dp[j], dp[j-nums[i]] + 1);
            }
        }

        return dp[n];

    }
}
// @lc code=end

