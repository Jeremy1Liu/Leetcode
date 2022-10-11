/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {

        //第i个房间的最大偷盗金额，由i之前两个房间的金额决定；
        //要么是i-1房间的值，此时不偷窃i房间；
        //要么是i-2房间的值，此时要加上i房间的金额。
        //取以上两个算法的最大值。
        //同时初始值要设定好，dp[0]和dp[1];
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i<nums.length+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        
        return dp[nums.length];
    }
}
// @lc code=end

