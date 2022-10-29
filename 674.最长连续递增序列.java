/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        //先写一个直观的方法吧；计算每个连续递增序列的长度，然后每个下降即为终止，开始从头计算
        //这个是贪心的方法。
        // int count = 1;
        // int res = 1;
        // for(int i=1; i<nums.length; i++) {
        //     if(nums[i] > nums[i-1]) {
        //         count++;
        //     }
        //     else{
        //         count = 1;
        //     }
        //     res = Math.max(res, count);
        // }
        // return res;

        //方法2：尝试使用dp[]
        //不连续递增子序列的跟前0-i 个状态有关，连续递增的子序列只跟前一个状态有关
        //因此只需要1次for循环。而不连续递增子序列需要2个for循环；
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            else {
                dp[i] = 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

    
}
// @lc code=end

