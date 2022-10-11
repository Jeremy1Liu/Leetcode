/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int maxSum=Integer.MIN_VALUE, curSum= 0;
        for(int i=0; i<nums.length; i++){

            curSum += nums[i];
            
            //我自己经常把这两段if写反，导致得不出负数的结果；
            //！！！应该先比较curSum和maxSum, 之后再去更新curSum；
            if(curSum > maxSum){
                maxSum = curSum;
            }
            if(curSum < 0){
                curSum = 0;
            }
            
        }
        return maxSum;

    }
}
// @lc code=end

