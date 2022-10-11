/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int leap = nums[0];
        for(int i=1; i< nums.length; i++){
            leap--;
            if(leap < 0){
                return false;
            }
            leap = Math.max(leap, nums[i]);
            

        }
        return true;
    }
}
// @lc code=end

