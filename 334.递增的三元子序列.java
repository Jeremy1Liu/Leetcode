/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3) return false;
        int min=nums[0], min2=Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            if(nums[i]<min) min = nums[i];
            else if(nums[i]>min && nums[i]<min2) min2 = nums[i];

            if(nums[i]>min2) return true;
        }
        return false;

    }
}
// @lc code=end

