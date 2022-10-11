/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int len= prices.length;
        int max = 0;

        if(len < 2) return 0;

        for(int i=1; i<len; i++){
            max += (prices[i]-prices[i-1] > 0) ? prices[i]-prices[i-1] : 0;
        }
        return max;
    }
}
// @lc code=end

