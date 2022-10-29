/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        //这道题的递推方程是：if(dp[i]>dp[j]) dp[i] = max(dp[i], dp[j]+1);
        //dp[i]的定义是当个位置及之前子数组的最大递增数组，即题目所求
        //那么dp[i]可以由之前所有的dp数组得出；
        //具体每个点是否为dp[j]+1, 需要一个判定条件：nums[i]>nums[j];

        int len = nums.length;
        int[] dp = new int[len];
        for(int i=0; i<len; i++){
            dp[i] = 1;
        }
        int res = 1;
        for(int i=1; i< len; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    //找寻i位置前置最大的dp[j],同时dp[i]>dp[j],因此dp[i] = dp[j]+1;
                    //同时需要遍历i前置的所有j，记录其最大元素。
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
// @lc code=end

