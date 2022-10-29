/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //核心思想，每个点的最大利润决定于左边的minPrice,
        //而且左边的minPrice是唯一的，而且是有方向的，只用从左向右遍历，并且记录之即可。
        //那就是求出每个点的最大profit（即prices[i] - minPrice左边的)，遍历一次数组即可。
        int res = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            int profit = prices[i] - minPrice;
            if(profit > res) res = profit;
        }

        return res;

    }
}
// @lc code=end

