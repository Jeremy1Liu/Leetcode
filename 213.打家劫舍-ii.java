/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        //通过把环形数组分类成为2种，要么不包含头节点，要么不包含尾节点。
        //通过帮助函数，2次计算，即可。
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[0];
        helper(nums, dp1, 1, nums.length - 1);
        dp2[0] = 0;
        dp2[1] = nums[1];
        helper(nums, dp2, 2, nums.length);
        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);


    }
    private int helper(int[] nums, int[] dp, int lo, int hi){
        for(int i=2; i<dp.length && lo<hi; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[lo++]);
        }

        return dp[nums.length-1];
    }
}
// @lc code=end

