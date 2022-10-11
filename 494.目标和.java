/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //把数组总和分为正数x, 负数sum-x, 则x-(sum-x) = target;
        //x = (target+sum)/2; 即为求nums中组合之和为x的背包；

        int sum=0;
        for(int num : nums) sum += num;
        if(target > sum || (target+sum)%2 == 1) return 0;

        int x = (target + sum) / 2;
        int[] dp = new int[x+1];
        int res = 0;
        for(int i=0; i<nums.length; i++)
            for(int j=x; j>=0; j--)
            {   dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if(dp[j] == x) res++;
            }
        
        return res;

    }
}
// @lc code=end

