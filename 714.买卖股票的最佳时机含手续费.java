/*
 * @lc app=leetcode.cn id=714 lang=java
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices, int fee) {
        //这种做法相当于在购买时支付fee, 之后如果没有交易，只是更新buy值，不增加fee
        int buy = prices[0] + fee;
        int res = 0;
        for(int i=1; i<prices.length; i++){
            if(buy > prices[i] + fee){
                //如果prices[i]更小，则更新左值；
                buy = prices[i] + fee;
            }
            //如果右值大于左值fee以上，则说明有利润，可以先存着利润；
            //同时更新左值，
            else if(prices[i] > buy){
                res += prices[i] - buy;
                //这一步很重要，不好理解；因为没有真的卖掉股票，
                //只是存着利润，所以left更新的值减去fee; m没有只有卖出操作，不计算fee
                //直到遇到了真的低价股票，则执行 if(left > prices[i])，更新真的买入股价。
                buy = prices[i];
            }
        }
        return res;
    }
}
// @lc code=end

